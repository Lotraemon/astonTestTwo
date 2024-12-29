import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayForm {
    By numberField = By.xpath("//*[@class='pay-form opened']/div[1]/input");
    By payValueField = By.xpath("//*[@class='pay-form opened']/div[2]/input");
    By emailField = By.xpath("//*[@class='pay-form opened']/div[3]/input");
    By aboutService = By.linkText("Подробнее о сервисе");
    By logos = By.xpath("//*[@class='pay__wrapper']//img");
    By title = By.xpath("//*[@class='pay__wrapper']/h2");
    By continueButton = By.xpath("//*[@id='pay-connection']/button");
    By selector = By.xpath("//*[@class='pay__form']//*[@class='select__header']");
    By homeInternetSelector = By.xpath("//*[@class='select__list']/li[2]");
    By creditSelector = By.xpath("//*[@class='select__list']/li[3]");
    By debtSelector = By.xpath("//*[@class='select__list']/li[4]");


    private final WebDriver driver;

    public PayForm(WebDriver driver) {
        this.driver = driver;
    }


    public PayForm checkNumberPlaceholder(String placeholder) {
        Assertions.assertEquals(placeholder, driver.findElement(numberField).getAttribute("placeholder"));
        return this;
    }

    public PayForm checkValuePlaceholder(String placeholder) {
        Assertions.assertEquals(placeholder, driver.findElement(payValueField).getAttribute("placeholder"));
        return this;
    }

    public PayForm checkEmailPlaceholder(String placeholder) {
        Assertions.assertEquals(placeholder, driver.findElement(emailField).getAttribute("placeholder"));
        return this;
    }

    public PayForm typeNumber(String number) {
        driver.findElement(numberField).sendKeys(number);
        return this;
    }

    public PayForm typeValue(String value) {
        driver.findElement(payValueField).sendKeys(value);
        return this;
    }

    public PayForm clickContinue() {
        driver.findElement(continueButton).click();
        return this;
    }

    public PayForm clickAboutService() {
        driver.findElement(aboutService).click();
        return this;
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public PayForm chooseHomeInternet() {
        driver.findElement(selector).click();
        driver.findElement(homeInternetSelector).click();
        return this;
    }

    public PayForm chooseCredit() {
        driver.findElement(selector).click();
        driver.findElement(creditSelector).click();
        return this;
    }

    public PayForm chooseDept() {
        driver.findElement(selector).click();
        driver.findElement(debtSelector).click();
        return this;
    }

}
