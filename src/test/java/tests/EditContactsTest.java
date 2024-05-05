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

public class EditContactsTest extends AppiumConfig {

    @Test
    public void editContactMailPositive(){
        String text = "updatedMail@mail.com";
        new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("myemail5@mail.com")
                .fillPasswordField("Tt123456$")
                .clickByLoginButton();
        Assert.assertTrue(new ContactListScreen(driver)
                .editOneContact().editEmailField(text)
                .submitChanges()
                .isContactContainsText(text));

    }

    @Test
    public void editAnyContactYouWant(){
        String text = EmailGenerator.generateEmail(5,3,2);
        new SplashScreen(driver)
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
                "test edit contact");
       Assert.assertTrue(new ContactListScreen(driver)
               .openNewContactForm()
               .fillTheForm(contact)
               .isContactAddedScroll(contact));


    }
}
