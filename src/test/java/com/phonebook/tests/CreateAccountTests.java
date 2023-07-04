package com.phonebook.tests;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
        //click on Login link
        app.getHeader().clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        //enter email field
        //enter password field
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("lega147@gmai.com")
                .setPassword("Oleg1"));
        //click on Registration
        app.getUser().clickOnRegistrationButton();
        //assert user logged in(check Sign Out button displayed)
        Assert.assertTrue(app.getUser().isAlertPresent()); // если выскочило модальное окно с ошибкой, то True
    }

}
