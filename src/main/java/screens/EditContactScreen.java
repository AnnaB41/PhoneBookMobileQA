package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class EditContactScreen extends BaseScreen{
    public EditContactScreen(AppiumDriver<MobileElement> driver) {
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

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/updateBtn']")
    MobileElement updateButton;


    public ContactListScreen submitChanges(){
        updateButton.click();
        return new ContactListScreen(driver);
    }

    public EditContactScreen editEmailField(String email){
        waitForAnElement(updateButton);
        inputEmail.clear();
        inputEmail.sendKeys(email);
        return this;
    }

}
