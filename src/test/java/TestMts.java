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
        List<WebElement> logos = driver.findElements(payForm.getLogos());
        for (int i = 0; i < altLogos.length; i++) {
            String altLogo = logos.get(i).getAttribute("alt");
            assertEquals(altLogos[i], altLogo);
            assertTrue(logos.get(i).isDisplayed());
        }
    }

    @Test
    public void testLink() {
        payForm.click(payForm.getAboutServiceLink());
        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"));
    }

    @Test
    public void testForm() {
        payForm.typeText(payForm.getFieldOne(), "297777777");
        payForm.typeText(payForm.getFieldTwo(), "10");
        payForm.click(payForm.getContinueButton());
        WebElement iframe = driver.findElement(By.cssSelector("iframe.bepaid-iframe"));
        driver.switchTo().frame(iframe);
    }

    @Test
    public void testMobilePlaceholder() {
        payForm.checkPlaceholder(payForm.getFieldOne(), "Номер телефона");
        payForm.checkPlaceholder(payForm.getFieldTwo(), "Сумма");
        payForm.checkPlaceholder(payForm.getFieldThree(), "E-mail для отправки чека");
    }

    @Test
    public void testHomeInternetPlaceholder() {
        payForm.chooseSelector(payForm.getHomeInternetSelector());
        payForm.checkPlaceholder(payForm.getFieldOne(), "Номер абонента");
        payForm.checkPlaceholder(payForm.getFieldTwo(), "Сумма");
        payForm.checkPlaceholder(payForm.getFieldThree(), "E-mail для отправки чека");
    }

    @Test
    public void testCreditPlaceholder() {
        payForm.chooseSelector(payForm.getCreditSelector());
        payForm.checkPlaceholder(payForm.getFieldOne(), "Номер счета на 44");
        payForm.checkPlaceholder(payForm.getFieldTwo(), "Сумма");
        payForm.checkPlaceholder(payForm.getFieldThree(), "E-mail для отправки чека");
    }

    @Test
    public void testDeptPlaceholder() {
        payForm.chooseSelector(payForm.getDebtSelector());
        payForm.checkPlaceholder(payForm.getFieldOne(), "Номер счета на 2073");
        payForm.checkPlaceholder(payForm.getFieldTwo(), "Сумма");
        payForm.checkPlaceholder(payForm.getFieldThree(), "E-mail для отправки чека");
    }

    @Test
    @Description("test BePaid form")
    public void testBePaid() {

        BePaid bePaid = new BePaid(driver);
        payForm.goToBePaid();
        assertAll("test BePaid form",
                () -> assertEquals("10.00 BYN", bePaid.getText(bePaid.getPriceValue())),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", bePaid.getText(bePaid.getPhoneNumber())),
                () -> assertEquals("Номер карты", bePaid.getText(bePaid.getNumberPlaceholder())),
                () -> assertEquals("Срок действия", bePaid.getText(bePaid.getPeriodPlaceholder())),
                () -> assertEquals("CVC", bePaid.getText(bePaid.getCvcPlaceholder())),
                () -> assertEquals("Имя держателя (как на карте)", bePaid.getText(bePaid.getUsernamePlaceholder())),
                () -> assertEquals("Оплатить 10.00 BYN", bePaid.getText(bePaid.getButton())),

                () -> assertTrue(bePaid.isIconVisible(bePaid.getVisaIcon())),
                () -> assertTrue(bePaid.isIconVisible(bePaid.getMastercardIcon())),
                () -> assertTrue(bePaid.isIconVisible(bePaid.getBelkartIcon())),
                () -> assertTrue(bePaid.isIconVisible(bePaid.getMirIcon1())),
                () -> assertTrue(bePaid.isIconVisible(bePaid.getMirIcon2()))
        );
    }
}