package stepdefs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyObservatoryStepDefs {

    AppiumDriver<MobileElement> driver;
    private static final String  BASE_URL = "http://localhost:4723/wd/hub";
    private static final String  DEVICE_NAME = "emulator-5554";
    private static final String  PLATFORM_NAME = "platformName";
    private static final String  ANDROID = "android";
    private static final String  APP_PACKAGE_NAME = "appPackage";
    private static final String  APP_ACTIVITY_NAME = "appActivity";
    private static final String  APP_PACKAGE = "hko.MyObservatory_v1_0";
    private static final String  APP_ACTIVITY = "hko.MyObservatory_v1_0.AgreementPage";
    private static final String  AGREE_BUTTON = ":id/btn_agree";

    @Given("The app is open")
    public void the_app_is_open() throws MalformedURLException {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
            dc.setCapability(PLATFORM_NAME, ANDROID);
            dc.setCapability(APP_PACKAGE_NAME, APP_PACKAGE);
            dc.setCapability(APP_ACTIVITY_NAME, APP_ACTIVITY);

            URL url = new URL(BASE_URL);

            driver = new AppiumDriver<>(url, dc);

    }

    @When("I navigate to the 9 Day Forecast Page")
    public void i_navigate_to_the_day_forecast_page() throws InterruptedException {
        MobileElement el2 = driver.findElementById(APP_PACKAGE+AGREE_BUTTON);
        el2.click();
        MobileElement el3 = driver.findElementById(APP_PACKAGE+AGREE_BUTTON);
        el3.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el4 = driver.findElementById("android:id/button1");
        el4.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el5 = driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
        el5.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el6 = driver.findElementByAccessibilityId("Close");
        el6.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el7 = driver.findElementByAccessibilityId("Navigate up");
        el7.click();

        Dimension dim = driver.manage().window().getSize();
        int startx = (int) (dim.width * 0.2);
        int starty = (int) (dim.height * 0.7);

        int endx = (int) (dim.width * 0.2);
        int endy = (int) (dim.height * 0.2);

        Thread.sleep(2000);

        TouchAction touch = new TouchAction(driver);
        touch.press(PointOption.point(startx,starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endx,endy)).release().perform();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el8 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[7]");
        el8.click();

    }

    @Then("I see the 9 Day Forecast Page")
    public void iSeeTheNineDayForecastPage() {
        Assert.assertEquals(driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"9-Day Forecast\"]/android.widget.TextView").getText(),"9-Day Forecast");
    }

    @Then("I see the forecast for the next 9 days")
    public void i_see_the_forecast_for_the_next_days() {
    }
}
