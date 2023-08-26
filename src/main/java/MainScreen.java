import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainScreen {


    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    public MobileElement mainText;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    public MobileElement input;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    public MobileElement buttonChange;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    public MobileElement buttonActivity;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    public MobileElement activityText;


    private AppiumDriver driver;

    public MainScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
