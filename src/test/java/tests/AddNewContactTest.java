package tests;

import config.AppiumConfig;
import helpers.*;
import models.ContactModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;


public class AddNewContactTest extends AppiumConfig {

    @Test
    public void addNewContactWithLogin(){
    ContactListScreen contactListScreen = new SplashScreen(driver)
            .switchToAuthScreen()
            .fillEmailField("myemail5@mail.com")
            .fillPasswordField("Tt123456$")
            .clickByLoginButton();
    ContactModel contact = new ContactModel(
            NameAndLastNameGenerator.generateName(),
            NameAndLastNameGenerator.generateLastName(),
            EmailGenerator.generateEmail(5, 3, 2),
            PhoneNumberGenerator.generatePhoneNumber(),
            AddressGenerator.generateAddress(),
            "mobile contact");

    int previousCount = contactListScreen.getContactsListSize();
        System.out.println(previousCount);
    ContactListScreen contactListScreen1 = new ContactListScreen(driver)
            .openNewContactForm()
            .fillTheForm(contact);
    int newCount = contactListScreen1.getContactsListSize();
        System.out.println(newCount);
    Assert.assertTrue(newCount > previousCount); // получаю только то количество, которое вижу на экране


}

    @Test
    public void addNewContactWithRegistration(){
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField(EmailGenerator.generateEmail(5,3,2))
                .fillPasswordField(PasswordStringGenerator.generateString())
                .clickByRegistrationButton();
        ContactModel contact = new ContactModel(
                NameAndLastNameGenerator.generateName(),
                NameAndLastNameGenerator.generateLastName(),
                EmailGenerator.generateEmail(5,3,2),
                PhoneNumberGenerator.generatePhoneNumber(),
                AddressGenerator.generateAddress(),
                "mobile contact");

                ContactListScreen contactListScreen1 = new ContactListScreen(driver)
                .openNewContactForm()
                .fillTheForm(contact);


        Assert.assertTrue(contactListScreen1.getContactsListSize()>0);



    }


}
