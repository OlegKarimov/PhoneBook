package com.phonebook.tests;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
        app.getHeader().clickOnLoginLink();
    }

    @Test(priority = 1)
    public void loginPositiveTest() {
        //enter email field
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("lega147@gmai.com")
                .setPassword("Oleg123$-_$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert user logged in(check Sign Out button displayed)
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test(priority = 2)
    public void loginNegativeWithoutPasswordTest() {
        //enter email field
        app.getUser().fillLoginRegistrationForm(new User().setEmail("lega147@gmai.com"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
    @Test(priority = 3)
    public void loginTrue_PasswordFalse_NegativeTest() {
        //enter email field
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("lega147@gmai.com")
                .setPassword("Oleg123"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
    @Test(priority = 4)
    public void loginFalse_PasswordTrue_NegativeTest() {
        //enter email field
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("lega147@ddddddd.com")
                .setPassword("Oleg123$-_$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
