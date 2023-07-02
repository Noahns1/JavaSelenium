package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class AmazonSteps {

    WebDriver driver;

    @Given("User opens up Chrome")
    public void user_is_on_chrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Then("User goes to Amazon")
    public void userGoesToAmazon() {
        driver.get("https://www.amazon.com/");
    }

    @When("User clicks on search bar")
    public void userClicksOnSearchBar() {
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.click();
    }

    @And("User searches for selenium book")
    public void userSearchesForSeleniumBook() {
        WebElement searchBook = driver.findElement(By.id("twotabsearchtextbox"));
        searchBook.sendKeys("selenium book");
        WebElement search = driver.findElement(By.id("nav-search-submit-button"));
        search.click();
    }

    @Then("Selects selenium book")
    public void selectsSeleniumBook() {
        WebElement seleniumBook = driver.findElement(By.linkText("Hands-On Selenium WebDriver with Java: " +
                                                                "A Deep Dive into the Development of " +
                                                                "End-to-End Tests"));
        seleniumBook.click();
    }

    @And("User is on the item page")
    public void userIsOnTheItemPage() {
        WebElement correctItem = driver.findElement(By.id("productTitle"));
        String actualCorrectItem = correctItem.getText();
        String expectedCorrectItem = "Hands-On Selenium WebDriver with Java: " +
                                     "A Deep Dive into the Development of End-to-End Tests";
        Assert.assertEquals(actualCorrectItem, expectedCorrectItem);
    }

    @When("User clicks on Add to Cart")
    public void userClicksOnAddToCart() {
        WebElement addCart = driver.findElement(By.id("add-to-cart-button"));
        addCart.click();
    }

    @And("User navigates to cart")
    public void userNavigatesToCart() {
        WebElement goToCart = driver.findElement(By.linkText("Go to Cart"));
        goToCart.click();
    }

    @And("User Verifies selenium book is in cart")
    public void userVerifiesSeleniumBookIsInCart() {
        WebElement cartValidation = driver.findElement(By.linkText("Hands-On Selenium WebDriver with Java: " +
                                                                  "A Deep Dive into the Development of " +
                                                                  "End-to-End Tests"));
    }

    @Then("close browser")
    public void closeBrowser() {
        driver.close();
    }
}
