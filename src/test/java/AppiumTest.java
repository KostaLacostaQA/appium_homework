import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.TestInstance.Lifecycle;

import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(Lifecycle.PER_CLASS)
public class AppiumTest {

    private AppiumDriver driver;

    MainScreen mainScreen;


    @BeforeAll
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
    public void emptyTextTest() {
        String beforeMainText = mainScreen.mainText.getText();

        mainScreen.input.sendKeys(" ");
        mainScreen.buttonChange.click();

        Assertions.assertEquals(beforeMainText, mainScreen.mainText.getText());
    }

    @Test
    public void activityTextTest() {
        String text = "Hello World!";

        mainScreen.input.sendKeys(text);
        mainScreen.buttonActivity.click();

        Assertions.assertEquals(text, mainScreen.activityText.getText());
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
