package pl.lakota.forum.controller;

import pl.lakota.forum.config.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ForumController {

    private static final String WELCOME_PAGE = "welcome-page";
    private static final String VERIFICATION_PAGE = "verification-page";
    private static final String FORUM_PAGE = "forum-page";

    @GetMapping("/")
    public String getWelcomePage(Model model) {
        model.addAttribute("user", new User());
        return WELCOME_PAGE;
    }

    @PostMapping("/proceedToVerification")
    public String proceedToVerification(@ModelAttribute("user") User user, Model model) {
        return goToVerificationPage(user, model);
    }

    @PostMapping("/proceedToForum")
    public String proceedToForum(@ModelAttribute("user") User user, Model model) {
        String riddle = user.getRiddle();
        Integer result = User.RIDDLES.get(riddle);
        Integer resultFromUser = user.getVerificationResult();

        if (resultFromUser.equals(result)) {
            return FORUM_PAGE;
        } else {
            return goToVerificationPage(user, model);
        }
    }

    private String goToVerificationPage(User user, Model model) {
        user.shuffleRiddle();
        model.addAttribute("user", user);
        return VERIFICATION_PAGE;
    }
}