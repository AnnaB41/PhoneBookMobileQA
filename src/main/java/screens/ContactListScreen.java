package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactListScreen extends BaseScreen{
    public ContactListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement moreOptions;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement logoutButton;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement titleText; // сначала находим род.элемент, потом дочерний

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/add_contact_btn']")
    MobileElement addButton;

    @FindBy(id = "com.sheygam.contactapp:id/recyclerView")
    MobileElement listContacts;

    public AuthenticationScreen logout(){
        moreOptions.click();
        logoutButton.click();
        return new AuthenticationScreen(driver);
    }

    public boolean isContactListPresent(){
       return isElementPresent(titleText, "Contact list");
    }

    public AddNewContactScreen openNewContactForm(){
        waitForAnElement(addButton);
        addButton.click();
        return new AddNewContactScreen(driver);
    }

    protected List<MobileElement> getContactsList(){
        return listContacts.findElements(By.className("android.widget.LinearLayout"));
    }
    public int getContactsListSize(){
        return getContactsList().size();
    }



 //   public
//     List<ContactModel> allContacts = listContacts.findElements(By.className("android.widget.LinearLayout"));
//
//    public boolean isContactAddedByRegistration(){
//
//        if(allContacts.size()>0){
//            return true;
//        }
//        return false;
//    }












}