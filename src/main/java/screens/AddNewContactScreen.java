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
        waitForAnElement(btnCreate);
        inputName.sendKeys(contact.getName());
        driver.hideKeyboard(); // это скрытие клавиатуры
        inputLastname.sendKeys(contact.getLastName());
        driver.hideKeyboard(); // это скрытие клавиатуры
        inputEmail.sendKeys(contact.getEmail());
        driver.hideKeyboard(); // это скрытие клавиатуры
        inputPhone.sendKeys(contact.getPhone());
        driver.hideKeyboard(); // это скрытие клавиатуры
        inputAddress.sendKeys(contact.getAddress());
        driver.hideKeyboard();
        inputDescription.sendKeys(contact.getDescription());
        driver.hideKeyboard();
        btnCreate.click();
        return new ContactListScreen(driver);
    }





// описать все поля, создать метод, который будет добавлять контакт в поля, нажать на кнопку create
}
