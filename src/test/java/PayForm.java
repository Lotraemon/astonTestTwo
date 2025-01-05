import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayForm {

    By numberField = By.xpath("//*[@class='pay-form opened']/div[1]/input");
    By payValueField = By.xpath("//*[@class='pay-form opened']/div[2]/input");
    By emailField = By.xpath("//*[@class='pay-form opened']/div[3]/input");
    By aboutServiceLink = By.linkText("Подробнее о сервисе");
    By logos = By.xpath("//*[@class='pay__wrapper']//img");
    By title = By.xpath("//*[@class='pay__wrapper']/h2");
    By continueButton = By.xpath("//*[@id='pay-connection']/button");
    By selector = By.xpath("//*[@class='pay__form']//*[@class='select__header']");
    By homeInternetSelector = By.xpath("//*[@class='select__option' and text()='Домашний интернет']");
    By creditSelector = By.xpath("//*[@class='select__list']//*[@class='select__option' and text()='Рассрочка']");
    By debtSelector = By.xpath("//*[@class='select__list']//*[@class='select__option' and text()='Задолженность']");


    private final WebDriver driver;

    public PayForm(WebDriver driver) {
        this.driver = driver;
    }


    public PayForm checkPlaceholder(By by, String placeholder) {
        Assertions.assertEquals(placeholder, driver.findElement(by).getAttribute("placeholder"));
        return this;
    }

    public PayForm typeText(By by, String number) {
        driver.findElement(by).sendKeys(number);
        return this;
    }

    public PayForm click(By by) {
        driver.findElement(by).click();
        return this;
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public PayForm chooseSelector(By by) {
        driver.findElement(selector).click();
        driver.findElement(by).click();
        return this;
    }
    public void goToBePaid() {
        typeText(numberField, "297777777");
        typeText(payValueField, "10");
        click(continueButton);
        WebElement iframe = driver.findElement(By.cssSelector("iframe.bepaid-iframe"));
        driver.switchTo().frame(iframe);
    }
}
