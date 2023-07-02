package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class TestDriveSteps {

    WebDriver driver;

    @Given("User is on Chrome")
    public void user_is_on_chrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("User goes to google")
    public void user_goes_to_google() {
        driver.get("https://www.google.com/");
    }

    @Then("Window closes")
    public void window_closes() {
        driver.close();
    }


}
