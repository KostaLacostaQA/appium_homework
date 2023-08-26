import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumTest {

    private AppiumDriver driver;

    MainScreen mainScreen;


    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:deviceName", "some name");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), desiredCapabilities);
        mainScreen = new MainScreen(driver);
    }

    @Test
    public void emptyText() {
        String beforeMainText = mainScreen.mainText.getText();

        mainScreen.input.sendKeys(" ");
        mainScreen.buttonChange.click();

        Assertions.assertEquals(beforeMainText, mainScreen.mainText.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
