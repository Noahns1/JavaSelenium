package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Map;


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

    //Below scripts are for scenario: incorrectly attempt to create an account

    @When("User clicks Account & Lists")
    public void userClicksAccountLists() {
        WebElement accountAndList = driver.findElement(By.id("nav-link-accountList"));
        accountAndList.click();
    }

    @Then("User is on Sign in page")
    public void userIsOnSignInPage() {
        WebElement signInTitle = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]" +
                "/div[2]/div[1]/form/div/div/div/h1"));
        String actualSignInTitle = signInTitle.getText();
        String expectedSignInTitle = "Sign in";
        Assert.assertEquals(actualSignInTitle, expectedSignInTitle);
    }

    @When("User clicks Create your Amazon account")
    public void userClicksCreateYourAmazonAccount() {
        WebElement createAccount = driver.findElement(By.id("createAccountSubmit"));
        createAccount.click();
    }

    @Then("User is on Create account page")
    public void userIsOnCreateAccountPage() {
        WebElement signInTitle = driver.findElement(By.xpath("//*[@id=\"ap_register_form\"]/div/div/h1"));
        String actualSignInTitle = signInTitle.getText();
        String expectedSignInTitle = "Create account";
        Assert.assertEquals(actualSignInTitle, expectedSignInTitle);
    }

    @And("User clicks continue")
    public void userClicksContinue() {
        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
    }

    @Then("Verifies error messages from incorrect entries")
    public void verifiesErrorMessagesFromIncorrectEntries(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            String fieldId = entry.getKey();
            String value = entry.getValue();

            WebElement findError = driver.findElement(By.id(fieldId));
            String actualError = findError.getText();
            Assert.assertEquals(value, actualError);
        }
    }

    @When("User enters invalid email")
    public void userEntersInvalidEmail() {
        WebElement badEmail = driver.findElement(By.id("ap_email"));
        badEmail.sendKeys("NotAnEmail");

        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
    }

    @Then("Verifies error message for email")
    public void verifiesErrorMessageForEmail() {
        WebElement emailError = driver.findElement(By.id("auth-email-invalid-claim-alert"));
        String actualEmailError = emailError.getText();
        String expectedEmailError = "Wrong or Invalid email address or mobile phone number. " +
                "Please correct and try again.";
        Assert.assertEquals(actualEmailError, expectedEmailError);
    }

    @When("User enter mismatching passwords")
    public void userEnterMismatchingPasswords() {
        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("password1");

        WebElement confirmPassword = driver.findElement(By.id("ap_password_check"));
        confirmPassword.sendKeys("password2");

        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
    }

    @Then("Verifies error message for mismatching password")
    public void verifiesErrorMessageForMismatchingPassword() {
        WebElement mismatchPW = driver.findElement(By.id("auth-password-mismatch-alert"));
        String actualMismatchPW = mismatchPW.getText();
        String expectedMismatchPW = "Passwords must match";
        Assert.assertEquals(actualMismatchPW, expectedMismatchPW);
    }

    @When("User enters an improper password")
    public void userEntersAnImproperPassword() {
        WebElement badPW = driver.findElement(By.id("ap_password"));
        badPW.clear();
        badPW.sendKeys("badpw");

        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
    }

    @Then("Verifies error message for improper password")
    public void verifiesErrorMessageForImproperPassword() {
        WebElement badPWError = driver.findElement(By.id("auth-password-invalid-password-alert"));
        String actualBadPWError = badPWError.getText();
        String expectedBadPWError = "Minimum 6 characters required";
        Assert.assertEquals(actualBadPWError, expectedBadPWError);
    }

    //Below scripts are for scenario: Amazon - Validate text on item

    @And("User searches for Python Selenium book")
    public void userSearchesForPythonSeleniumBook() {
        WebElement searchPythonBook = driver.findElement(By.id("twotabsearchtextbox"));
        searchPythonBook.sendKeys("Python Selenium book");

        WebElement searchBTN = driver.findElement(By.id("nav-search-submit-button"));
        searchBTN.click();
    }

    @And("User selects a Python Selenium book")
    public void userSelectsAPythonSeleniumBook() {
        WebElement findBook = driver.findElement(By.linkText("Test-Driven Development with Python: Obey the Testing Goat: " +
                "Using Django, Selenium, and JavaScript"));
        findBook.click();
    }

    @And("Clicks on Read more")
    public void clicksOnReadMore() {
        WebElement readMore = driver.findElement(By.linkText("Read more"));
        readMore.click();
    }

    @Then("User validates Title and Author on item page")
    public void userValidatesTitleAndAuthorOnItemPage(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            String fieldId = entry.getKey();
            String value = entry.getValue();

            WebElement findError = driver.findElement(By.id(fieldId));
            String actualError = findError.getText();
            Assert.assertEquals(value, actualError);
        }
    }

    @Then("User validates book description")
    public void userValidatesBookDescription(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            String fieldPath = entry.getKey();
            String value = entry.getValue();

            WebElement findError = driver.findElement(By.xpath(fieldPath));
            String actualError = findError.getText();
            Assert.assertEquals(value, actualError);
        }
    }

    @Then("User validates preface")
    public void userValidatesPreface() {
        WebElement findPreface = driver.findElement(By.xpath("//*[contains(text(), 'From the Preface')]"));
    }
}
