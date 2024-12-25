import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestMts {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mts.by/");
        WebElement closeCookie = driver.findElement(By.xpath("//*[@class='btn btn_gray cookie__cancel']"));
        closeCookie.click();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testBlockTitle() {
        WebElement textBlock = driver.findElement(By.xpath("//*[@class='pay__wrapper']/h2"));
        Assertions.assertEquals("Онлайн пополнение\n" + "без комиссии", textBlock.getText());
    }

    @Test
    void testLogos() {
        String[] altLogos = new String[]{"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        List<WebElement> logos = driver.findElements(By.xpath("//*[@class='pay__wrapper']//ul/li/img"));
        for (int i = 0; i < altLogos.length; i++) {
            String altLogo = logos.get(i).getAttribute("alt");
            Assertions.assertEquals(altLogos[i], altLogo);
        }
    }

    @Test
    void testLink() {
        WebElement checklLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        checklLink.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"));
    }

    @Test
    void TestForm() {
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@class='pay__form']//*[@id='connection-phone']"));
        phoneNumber.sendKeys("297777777");
        WebElement connectionSum = driver.findElement(By.xpath("//*[@class='pay__form']//*[@id='connection-sum']"));
        connectionSum.sendKeys("10");
        WebElement confirm = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        confirm.click();
        WebElement iframe = driver.findElement(By.cssSelector("iframe.bepaid-iframe"));
        driver.switchTo().frame(iframe);
        WebElement bepaidApp = driver.findElement(By.xpath("//*[@id='cc-number']"));//cc-number
        Assertions.assertTrue(bepaidApp.isEnabled());

    }
}