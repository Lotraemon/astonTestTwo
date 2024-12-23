import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testBlockTitle() {
        driver.get("http://mts.by/");
        WebElement textBlock = driver.findElement(By.xpath("//*[@class='pay__wrapper']/h2"));
        Assertions.assertEquals("Онлайн пополнение\n" + "без комиссии", textBlock.getText());
    }

    @Test
    void testLogos() {
        String[] altLogos = new String[]{"VISA", "Verifided by VISA",
                "MasterCard", "MasterCard Secure Code", "Белкарт"};
        driver.get("http://mts.by/");
        WebElement logo = driver.findElement(By.xpath("//*[@id='pay-section']//ul/li[1]/img"));
        String altLogo = logo.getAttribute("alt");
        Assertions.assertEquals("Visa", altLogo);
    }
}