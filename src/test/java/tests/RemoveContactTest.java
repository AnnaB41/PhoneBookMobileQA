package tests;

import config.AppiumConfig;
import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RemoveContactTest extends AppiumConfig {

//    @BeforeTest
//    public void precondition(){
//        ContactListScreen contactListScreen = new SplashScreen(driver)
//                .switchToAuthScreen()
//                .fillEmailField("myemail5@mail.com")
//                .fillPasswordField("Tt123456$")
//                .clickByLoginButton();
//    }
    @Test
    public void removeContact(){
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("myemail5@mail.com")
                .fillPasswordField("Tt123456$")
                .clickByLoginButton();
        Contact contact = new Contact(
                NameAndLastNameGenerator.generateName(),
                NameAndLastNameGenerator.generateLastName(),
                EmailGenerator.generateEmail(5,3,2),
                PhoneNumberGenerator.generatePhoneNumber(),
                AddressGenerator.generateAddress(),
                "mobile contact for removing");
        contactListScreen.openNewContactForm().fillTheForm(contact);
        Assert.assertTrue(contactListScreen.removeContact().isContactRemoved());

    }

    @Test
    public void removeAllContacts(){
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("myemail5@mail.com")
                .fillPasswordField("Tt123456$")
                .clickByLoginButton();
        contactListScreen.removeAllContacts().isNoContactsMessage();


    }
}
