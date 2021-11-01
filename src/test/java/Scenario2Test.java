import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.pages.PageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Scenario2Test extends PageObject {

    public String GHOST_BASE_URL = "https://ghost.org/";
    public String BLOG_NAME = "aleksandraqa";
    public String BLOG_BASE_URL = "https://aleksandraqa.ghost.io";
    public String SIGN_IN_BUTTON = "//a[@id='signin-button']";
    public String SITE_ADDRESS_INPUT = "//input[@id='site']";
    public String CONTINUE_BUTTON = "//button[@id='signin']";
    public String BLOG_TITLE = "//h1";
    public long timeout = 3000L;
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
    void signInAsDeveloperAndCheckTitle(){
        driver.get(GHOST_BASE_URL);
        WebElement signInLink = driver.findElement(By.xpath(SIGN_IN_BUTTON));
        signInLink.click();
        WebElement siteAddressInput = driver.findElement(By.xpath(SITE_ADDRESS_INPUT));
        WebElement continueButton = driver.findElement(By.xpath(CONTINUE_BUTTON));
        siteAddressInput.sendKeys(BLOG_BASE_URL);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", continueButton);
        waitABit(timeout);
        WebElement blogTitle = driver.findElement(By.xpath(BLOG_TITLE));
        assertTrue(blogTitle.getText().contains(BLOG_NAME));
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
