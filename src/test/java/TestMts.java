import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestMts {

    private WebDriver driver;
    private PayForm payForm;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        payForm = new PayForm(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mts.by/");
        WebElement closeCookie = driver.findElement(By.xpath("//*[@class='btn btn_gray cookie__cancel']"));
        try {
            closeCookie.click();
        } catch (RuntimeException e) {
        }
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testBlockTitle() {
        Assertions.assertEquals("Онлайн пополнение\n" + "без комиссии", payForm.getTitleText());
    }

    @Test
    void testLogos() {
        String[] altLogos = new String[]{"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        List<WebElement> logos = driver.findElements(payForm.logos);
        for (int i = 0; i < altLogos.length; i++) {
            String altLogo = logos.get(i).getAttribute("alt");
            Assertions.assertEquals(altLogos[i], altLogo);
        }
    }

    @Test
    void testLink() {
        payForm.clickAboutService();
        Assertions.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"));
    }

    @Test
    void testForm() {
        payForm.typeNumber("297777777");
        payForm.typeValue("10");
        payForm.clickContinue();
        WebElement iframe = driver.findElement(By.cssSelector("iframe.bepaid-iframe"));
        driver.switchTo().frame(iframe);
    }

    @Test
    void testMobilePlaceholder() {
        payForm.checkNumberPlaceholder("Номер телефона");
        payForm.checkValuePlaceholder("Сумма");
        payForm.checkEmailPlaceholder("E-mail для отправки чека");
    }

    @Test
    void testHomeInternetPlaceholder() {
        payForm.chooseHomeInternet();
        payForm.checkNumberPlaceholder("Номер абонента");
        payForm.checkValuePlaceholder("Сумма");
        payForm.checkEmailPlaceholder("E-mail для отправки чека");
    }

    @Test
    void testCreditPlaceholder() {
        payForm.chooseCredit();
        payForm.checkNumberPlaceholder("Номер счета на 44");
        payForm.checkValuePlaceholder("Сумма");
        payForm.checkEmailPlaceholder("E-mail для отправки чека");
    }

    @Test
    void testDeptPlaceholder() {
        payForm.chooseDept();
        payForm.checkNumberPlaceholder("Номер счета на 2073");
        payForm.checkValuePlaceholder("Сумма");
        payForm.checkEmailPlaceholder("E-mail для отправки чека");
    }

    @Test
    void testBePaid() {

        BePaidFrame bePaidFrame = new BePaidFrame(driver);
        testForm();

        Assertions.assertEquals("10.00 BYN", bePaidFrame.getPriceValue());
        Assertions.assertEquals("Оплата: Услуги связи\n" + "Номер:375297777777", bePaidFrame.getPhoneNumber());
        Assertions.assertEquals("Номер карты", bePaidFrame.getNumberPlaceholder());
        Assertions.assertEquals("Срок действия", bePaidFrame.getPeriodPlaceholder());
        Assertions.assertEquals("CVC", bePaidFrame.getCvcPlaceholder());
        Assertions.assertEquals("Имя держателя (как на карте)", bePaidFrame.getUsernamePlaceholder());
        Assertions.assertEquals(" Оплатить  10.00 BYN ", bePaidFrame.getButtonText());
    }
}