package pl.lakota.forum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.lakota.forum.config.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lakota.forum.entity.PostDTO;
import pl.lakota.forum.entity.PostsContainer;
import pl.lakota.forum.service.DatabaseService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
 * TODO:
 *  1) unit test to every method;
 *  2) exception handling where required with the use of LOGGER;
 *  3) displaying exception message to user in the pop-up window;
 *  4) fix a bug regarding incomplete forum page after using "Refresh discussion forum page" button.
 */

@org.springframework.stereotype.Controller
public class Controller {

    // TODO Create a field for every column's and table's name in Forum.Posts.
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    private static final String FORUM_PAGE = "forum-page";
    static final String WELCOME_PAGE = "welcome-page";
    static final String MESSAGE_PAGE = "message-page";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String getWelcomePage(Model model) {
        User user = new User();
        user.setCaptcha();
        model.addAttribute("user", user);
        return WELCOME_PAGE;
    }

    @PostMapping("/proceedToForum")
    public String proceedToForum(@ModelAttribute("user") User user, Model model) {
        String captcha = user.getCaptcha();
        Integer result = User.CAPTCHAS.get(captcha);
        Integer resultFromUser = user.getResultOfCaptcha();

        if (resultFromUser.equals(result) && !user.getNickname().isBlank()) {
            String usersNickname = user.getNickname();
            model.addAttribute("post", new PostDTO(usersNickname));
            return goToForumPage(model);
        } else if (user.getNickname().isBlank()) {
            user.setShouldDisplayBlankNicknameAlertWindow(true);
        } else {
            user.setShouldDisplayIncorrectCaptchaAlertWindow(true);
        }

        user.setCaptcha();
        model.addAttribute("user", user);
        return WELCOME_PAGE;
    }

    @PostMapping("/goToForumPage")
    private String goToForumPage(Model model) {
        List<PostDTO> posts = DatabaseService.getImplementation().retrievePosts(jdbcTemplate);
        model.addAttribute("postsContainer", new PostsContainer(posts));
        return FORUM_PAGE;
    }

    @PostMapping("/goToSendMessagePage")
    public String goToSendMessagePage(@ModelAttribute("post") PostDTO post, Model model) {
        model.addAttribute("post", post);
        return MESSAGE_PAGE;
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute("post") PostDTO post, Model model) {
        try {
            jdbcTemplate.execute("INSERT INTO Posts(Nickname, Message, PostDate)\n" +
                    "VALUES ('" + post.getNickname() + "', '" + post.getMessage() + "', '" +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "')");
        } catch (DataAccessException exception) {
            LOGGER.warn(exception.getMessage());
        }
        return goToForumPage(model);
    }
}