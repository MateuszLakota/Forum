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

import java.text.SimpleDateFormat;
import java.util.Date;

@org.springframework.stereotype.Controller
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    private static final String WELCOME_PAGE = "welcome-page";
    private static final String MESSAGE_PAGE = "message-page";
    private static final String FORUM_PAGE = "forum-page";

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
        String riddle = user.getCaptcha();
        Integer result = User.CAPTCHAS.get(riddle);
        Integer resultFromUser = user.getResultOfCaptcha();

        if (resultFromUser.equals(result)) {
            String nick = user.getNickname();
            model.addAttribute("post", new PostDTO(nick));
            return MESSAGE_PAGE;
        } else {
            user.setCaptcha();
            model.addAttribute("user", user);
            return WELCOME_PAGE;
        }
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute("post") PostDTO post, Model model) {
        try {
            jdbcTemplate.execute("INSERT INTO Posts(Nickname, Message, PostDate)\n" +
                    "VALUES ('" + post.getNickname() + "', '" + post.getMessage() + "', '" +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "')");
        } catch (DataAccessException exception) {
            LOGGER.warn(exception.getMessage());
            //TODO Implement displaying exception message to user on the pop-up window
        }
        return FORUM_PAGE;
    }

    @PostMapping("/displayMessages")
    public void displayMessages(@ModelAttribute("post") User user, Model model) {
        jdbcTemplate.execute("SELECT Posts.Nickname, Posts.Message, Posts.PostDate FROM Posts WHERE Posts.Nickname = '"
                + user.getNickname() + "'");
        //TODO Implement user nickname's uniqueness verification in order to prevent from displaying foreign posts.
    }
}