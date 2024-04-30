package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.ContactModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactListScreen extends BaseScreen {
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

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowContainer']")
    List<MobileElement> contacts;  // получаем лист

    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement yesButton;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List<MobileElement> rowName;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowPhone']")
    List<MobileElement> rowPhone;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/emptyTxt']")
    MobileElement emptyListMessage;

    String phoneNumber;

    public AuthenticationScreen logout() {
        moreOptions.click();
        logoutButton.click();
        return new AuthenticationScreen(driver);
    }

    public boolean isContactListPresent() {
        return isElementPresent(titleText, "Contact list");
    }

    public AddNewContactScreen openNewContactForm() {
        waitForAnElement(addButton);
        addButton.click();
        return new AddNewContactScreen(driver);
    }

    protected List<MobileElement> getContactsList() {
        return listContacts.findElements(By.className("android.widget.LinearLayout"));
    }

    public int getContactsListSize() {
        return getContactsList().size();
    }

    public ContactListScreen removeContact() {
        waitForAnElement(addButton);
        MobileElement contact = contacts.get(0); // получаем первый контакт
        phoneNumber = rowPhone.get(0).getText();

        Rectangle rectangle = contact.getRect(); // получаем координаты прямоугольника первого контакта
        int xStart = rectangle.getX() + rectangle.getWidth() / 8; // стартовая х должна быть не в 0 а чуть сдвигаем на 1/8 от ширины
        int y = rectangle.getY() + rectangle.getHeight() / 2; // Y берем середину
        int xEnd = xStart + rectangle.getWidth() * 6 / 8; // сдвигаем точку х на 7/8

        new TouchAction<>(driver)  // свайп влево
                .longPress(PointOption.point(xStart, y))  // долгое нажатие
                .moveTo(PointOption.point(xEnd, y)) // сдвинуть
                .release() // отпусти
                .perform(); // выполни

        if (isElementPresent(yesButton, "YES")) {
            yesButton.click();
        }
        return this;
    }


    public boolean isContactRemoved() {
        return !rowPhone.contains(phoneNumber);
    }


    public boolean checkContainsText(List<MobileElement> list, String text){
        for(MobileElement mobileElement : list){
            if(mobileElement.getText().contains(text)){return true;}
        }
        return false;
    }
    public boolean isContactAdded(ContactModel contact){
        boolean checkName = checkContainsText(rowName, contact.getName());
        boolean checkPhone = checkContainsText(rowPhone, contact.getPhone());
        return checkName && checkPhone;

    }

    public ContactListScreen removeAllContacts() {
        waitForAnElement(addButton);
        while (contacts.size()>0){
            removeContact();
        }
        return this;
    }

    public boolean isNoContactsMessage() {
       return isElementPresent(emptyListMessage, "No Contacts");


    }
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












