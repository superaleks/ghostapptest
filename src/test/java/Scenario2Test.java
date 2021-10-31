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

class Scenario2Test {

    public String GHOST_BASE_URL = "https://ghost.org/";
    public String BLOG_NAME = "aleksandraqa";
    public String SITE_ADDRESS = BLOG_NAME + ".ghost.io";
    public String BLOG_BASE_URL = "https://aleksandraqa.ghost.io";
    public String BLOG_SIGN_IN = BLOG_BASE_URL +"/ghost/#/signin";
    public String SIGN_IN_BUTTON = "//a[@id='signin-button']";
    public String SITE_ADDRESS_INPUT = "//input[@id='site']";
    public String CONTINUE_BUTTON = "//button[@id='signin']";
    public String BLOG_TITLE = "//h1";
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @Test
    void signInAsDeveloperAndCheckTitle() throws InterruptedException {
        driver.get(GHOST_BASE_URL);
        WebElement signInLink = driver.findElement(By.xpath(SIGN_IN_BUTTON));
        signInLink.click();
        WebElement siteAddressInput = driver.findElement(By.xpath(SITE_ADDRESS_INPUT));
        WebElement continueButton = driver.findElement(By.xpath(CONTINUE_BUTTON));
        siteAddressInput.sendKeys(BLOG_BASE_URL);
        continueButton.click();
        WebElement blogTitle = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(BLOG_TITLE))));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("BLOG TITLE IS: " + blogTitle.getText());
        assertTrue(blogTitle.getText().contains(BLOG_NAME));
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
