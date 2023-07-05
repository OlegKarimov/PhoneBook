package com.phonebook.tests;

import com.phonebook.fw.DataProviders;
import com.phonebook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeTestFalseTelephone extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
        app.getHeader().clickOnLoginLink();
        app.getUser().login();
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "negativeTestFalseTelephoneAddContactFromCsvFile")
    public void addContactFromCsvFileNegativeTestFalseTelephone(Contact contact) {

        app.getHeader().clickOnAddLink();       // нажимаем на кнопку добавления контакта
        app.getContact().fillAddContactForm(contact);   // добавляем контакт

        app.getContact().clickOnSaveButton();   // нажимаем на кнопку сохранить контакт

        Assert.assertTrue(app.getUser().isAlertPresent()); // если выскочило модальное окно с ошибкой, то True

    }
}
