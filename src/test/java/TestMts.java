import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class TestMts {

    private WebDriver driver;
    private PayForm payForm;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    public void setupTest() {
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
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testBlockTitle() {

        assertEquals("Онлайн пополнение\n" + "без комиссии", payForm.getTitleText());
    }

    @Test
    public void testLogos() {
        String[] altLogos = new String[]{"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        List<WebElement> logos = driver.findElements(payForm.logos);
        for (int i = 0; i < altLogos.length; i++) {
            String altLogo = logos.get(i).getAttribute("alt");
            assertEquals(altLogos[i], altLogo);
            assertTrue(logos.get(i).isDisplayed());
        }
    }

    @Test
    public void testLink() {
        payForm.click(payForm.aboutServiceLink);
        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"));
    }

    @Test
    public void testForm() {
        payForm.typeText(payForm.numberField, "297777777");
        payForm.typeText(payForm.payValueField, "10");
        payForm.click(payForm.continueButton);
        WebElement iframe = driver.findElement(By.cssSelector("iframe.bepaid-iframe"));
        driver.switchTo().frame(iframe);
    }

    @Test
    public void testMobilePlaceholder() {
        payForm.checkPlaceholder(payForm.numberField, "Номер телефона");
        payForm.checkPlaceholder(payForm.payValueField, "Сумма");
        payForm.checkPlaceholder(payForm.emailField, "E-mail для отправки чека");
    }

    @Test
    public void testHomeInternetPlaceholder() {
        payForm.chooseSelector(payForm.homeInternetSelector);
        payForm.checkPlaceholder(payForm.numberField, "Номер абонента");
        payForm.checkPlaceholder(payForm.payValueField, "Сумма");
        payForm.checkPlaceholder(payForm.emailField, "E-mail для отправки чека");
    }

    @Test
    public void testCreditPlaceholder() {
        payForm.chooseSelector(payForm.creditSelector);
        payForm.checkPlaceholder(payForm.numberField, "Номер счета на 44");
        payForm.checkPlaceholder(payForm.payValueField, "Сумма");
        payForm.checkPlaceholder(payForm.emailField, "E-mail для отправки чека");
    }

    @Test
    public void testDeptPlaceholder() {
        payForm.chooseSelector(payForm.debtSelector);
        payForm.checkPlaceholder(payForm.numberField, "Номер счета на 2073");
        payForm.checkPlaceholder(payForm.payValueField, "Сумма");
        payForm.checkPlaceholder(payForm.emailField, "E-mail для отправки чека");
    }

    @Test
    @Description("test BePaid form")
    public void testBePaid() {

        BePaid bePaid = new BePaid(driver);
        payForm.goToBePaid();
        assertAll("test BePaid form",
                () -> assertEquals("10.00 BYN", bePaid.getText(bePaid.priceValue)),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", bePaid.getText(bePaid.phoneNumber)),
                () -> assertEquals("Номер карты", bePaid.getText(bePaid.numberPlaceholder)),
                () -> assertEquals("Срок действия", bePaid.getText(bePaid.periodPlaceholder)),
                () -> assertEquals("CVC", bePaid.getText(bePaid.cvcPlaceholder)),
                () -> assertEquals("Имя держателя (как на карте)", bePaid.getText(bePaid.usernamePlaceholder)),
                () -> assertEquals("Оплатить 10.00 BYN", bePaid.getText(bePaid.button)),

                () -> assertTrue(bePaid.isIconVisible(bePaid.visaIcon)),
                () -> assertTrue(bePaid.isIconVisible(bePaid.mastercardIcon)),
                () -> assertTrue(bePaid.isIconVisible(bePaid.belkartIcon)),
                () -> assertTrue(bePaid.isIconVisible(bePaid.mirIcon1)),
                () -> assertTrue(bePaid.isIconVisible(bePaid.mirIcon2))
        );
    }
}