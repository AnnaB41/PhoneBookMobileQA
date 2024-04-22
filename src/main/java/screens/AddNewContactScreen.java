package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.ContactModel;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen{
    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputName']")
    MobileElement inputName;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputLastName']")
    MobileElement inputLastname;
       @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement inputEmail;
       @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPhone']")
    MobileElement inputPhone;
       @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputAddress']")
    MobileElement inputAddress;
       @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputDesc']")
    MobileElement inputDescription;

       @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/createBtn']")
       MobileElement btnCreate;

    public ContactListScreen fillTheForm(ContactModel contact) {
        inputName.sendKeys(contact.getName());
        inputLastname.sendKeys(contact.getLastName());
        inputEmail.sendKeys(contact.getEmail());
        inputPhone.sendKeys(contact.getPhone());
        inputAddress.sendKeys(contact.getAddress());
        inputDescription.sendKeys(contact.getDescription());
        btnCreate.click();
        return new ContactListScreen(driver);
    }





// описать все поля, создать метод, который будет добавлять контакт в поля, нажать на кнопку create
}
