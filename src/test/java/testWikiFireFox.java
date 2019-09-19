import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testWikiFireFox {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://en.wikipedia.org");
        WebElement webElement = driver.findElement(By.xpath("//a[@href='/wiki/Wikipedia:About']"));
        webElement.click();
        Thread.sleep(3000);
        WebElement logo = driver.findElement(By.xpath("//h1[@id='firstHeading']"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
