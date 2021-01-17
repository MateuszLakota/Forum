package pl.lakota.forum.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.ui.Model;
import pl.lakota.forum.config.User;
import pl.lakota.forum.entity.PostDTO;

@SpringBootTest
class ControllerTest {
    @Autowired
    private Controller underTest;

    //@Test
    @Description("Test whether User class has been instantiated.")
    void getWelcomePage_testUserClassInstantiation() {

    }

    //@Test
    @Description("Test whether User instance's field has been initialized.")
    void getWelcomePage_testUserSetCaptchaMethod() {
        Model mockModel = Mockito.mock(Model.class);
        underTest.getWelcomePage(mockModel);
    }

    @Test
    @Description("Test whether addAttribute method has been invoked on Model's instance.")
    void getWelcomePage_testAddAttributeMethod() {
        Model mockModel = Mockito.mock(Model.class);
        underTest.getWelcomePage(mockModel);
        Mockito.verify(mockModel, Mockito.times(1)).addAttribute(Mockito.eq("user"), Mockito.any());
    }

    @Test
    @Description("Test whether WELCOME_PAGE has been returned.")
    void getWelcomePage_testReturnValue() {
        Model mockModel = Mockito.mock(Model.class);
        String welcomePageString = underTest.getWelcomePage(mockModel);
        Assertions.assertEquals(Controller.WELCOME_PAGE, welcomePageString);
    }

    @Test
    @Description("Test whether WELCOME_PAGE has been returned.")
    void proceedToForum_testReturnValue() {
        Model mockModel = Mockito.mock(Model.class);
        User mockUser = Mockito.mock(User.class);
        Mockito.when(mockUser.getNickname()).thenReturn("Mock nickname.");
        String welcomePage = underTest.proceedToForum(mockUser, mockModel);
        Assertions.assertEquals(Controller.WELCOME_PAGE, welcomePage);
    }

    @Test
    @Description("Test whether addAttribute method has been invoked on Model's instance.")
    void goToSendMessagePage_testAddAttributeMethod() {
        PostDTO mockPostDTO = Mockito.mock(PostDTO.class);
        Model mockModel = Mockito.mock(Model.class);
        underTest.goToSendMessagePage(mockPostDTO, mockModel);
        Mockito.verify(mockModel, Mockito.times(1)).addAttribute(Mockito.eq("post"), Mockito.any());
    }

    @Test
    @Description("Test whether MESSAGE_PAGE has been returned.")
    void goToSendMessagePage_testReturnValue() {
        Model mockModel = Mockito.mock(Model.class);
        PostDTO mockPostDTO = Mockito.mock(PostDTO.class);
        String messagePage = underTest.goToSendMessagePage(mockPostDTO, mockModel);
        Assertions.assertEquals(Controller.MESSAGE_PAGE, messagePage);
    }

    //@Test
    @Description("Test whether insert query has been executed.")
    void sendMessage_testSQLInsertQuery() {

    }

    //@Test
    @Description("Test whether goToForumPage method has been invoked.")
    void sendMessage_testGoToForumPageMethod() {
        Model mockModel = Mockito.mock(Model.class);
        PostDTO mockPostDTO = Mockito.mock(PostDTO.class);
        underTest.sendMessage(mockPostDTO, mockModel);
        Mockito.verify(mockModel, Mockito.times(1)).addAttribute(Mockito.eq("post"), Mockito.any());
    }
}