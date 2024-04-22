package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumConfig {

    public static AppiumDriver<MobileElement> driver; // Это статическое поле класса, которое представляет собой экземпляр драйвера Appium.


    @BeforeSuite  // Это аннотация TestNG, которая обозначает метод, который должен быть выполнен перед выполнением всех тестов
    public void setUp() throws MalformedURLException {
        /*В DesiredCapabilities задаются параметры для запуска мобильного приложения, такие как platformName,
         deviceName, platformVersion, appPackage, appActivity */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        /*
        "platformName": "Android",
  "deviceName": "Pixel",
  "platformVersion": "8.0",
  "appPackage": "com.sheygam.contactapp",
  "appActivity": ".SplashActivity"
         */
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("appPackage", "com.sheygam.contactapp");
        capabilities.setCapability("appActivity", ".SplashActivity");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium"); // Этот параметр указывает на то,
        // что при запуске приложения будет использоваться Appium как инструмент автоматизации.
        // Установка этого параметра гарантирует, что Appium будет использовать собственный механизм автоматизации.
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Projects\\APK\\contacts-android.apk");
        // Установка этого параметра гарантирует, что Appium будет использовать собственный механизм автоматизации.Appium
        // использует этот параметр, чтобы указать, какое приложение нужно запустить на целевом устройстве или эмуляторе.

        // создается новый экземпляр драйвера AppiumDriver с указанными параметрами и устанавливается
        // неявное ожидание (implicitlyWait) в 5 секунд.

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
