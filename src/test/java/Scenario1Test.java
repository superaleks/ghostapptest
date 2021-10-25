import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Scenario1Test {

    public String BASE_URL = "http://localhost/";
    public String SIGNUP_URL = BASE_URL +"portal/signup";

    public static String SIGN_IN_LINK = "//*[contains(text(),'Sign in')]";
    public static String EMAIL_TEXT_FIELD = "//input[@id='input-email']";
    public static String EMAIL = "aleksandra@yopmail.com";
    public static String CONTINUE_BUTTON = "//*[contains(text(),'Continue')]";

    public static String SUBSCRIBE_BUTTON = "//a[@class='gh-head-button']";
    public static String PAGE_TITLE = "//h1[@class='site-title']";

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testIfPageTitleLoads() {
        driver.get(BASE_URL);
        WebElement pageTitle = driver.findElement(By.xpath(PAGE_TITLE));
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(pageTitle));
        driver.findElement(By.xpath(PAGE_TITLE)).getText();
        assertTrue(pageTitle.isDisplayed());
    }

    @Test
    void testIfUserCanSignIn(){
        driver.get(SIGNUP_URL);
        WebElement signInLink = driver.findElement(By.xpath(SIGN_IN_LINK));
        WebElement emailTextField = driver.findElement(By.xpath(EMAIL_TEXT_FIELD));
        WebElement continueButton = driver.findElement(By.xpath(CONTINUE_BUTTON));
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(signInLink));
        signInLink.click();
        emailTextField.sendKeys(EMAIL);
        continueButton.click();
    }
}

