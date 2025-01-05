import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayForm {

    private By fieldOne = By.xpath("//*[@class='pay-form opened']/div[1]/input");
    private By fieldTwo = By.xpath("//*[@class='pay-form opened']/div[2]/input");
    private By fieldThree = By.xpath("//*[@class='pay-form opened']/div[3]/input");
    private By aboutServiceLink = By.linkText("Подробнее о сервисе");
    private By logos = By.xpath("//*[@class='pay__wrapper']//img");
    private By title = By.xpath("//*[@class='pay__wrapper']/h2");
    private By continueButton = By.xpath("//*[@id='pay-connection']/button");
    private By selector = By.xpath("//*[@class='pay__form']//*[@class='select__header']");
    private By homeInternetSelector = By.xpath("//*[@class='select__option' and text()='Домашний интернет']");
    private By creditSelector = By.xpath("//*[@class='select__list']//*[@class='select__option' and text()='Рассрочка']");
    private By debtSelector = By.xpath("//*[@class='select__list']//*[@class='select__option' and text()='Задолженность']");

    public By getFieldOne() {
        return fieldOne;
    }

    public By getFieldTwo() {
        return fieldTwo;
    }

    public By getFieldThree() {
        return fieldThree;
    }

    public By getAboutServiceLink() {
        return aboutServiceLink;
    }

    public By getLogos() {
        return logos;
    }

    public By getContinueButton() {
        return continueButton;
    }

    public By getHomeInternetSelector() {
        return homeInternetSelector;
    }

    public By getCreditSelector() {
        return creditSelector;
    }

    public By getDebtSelector() {
        return debtSelector;
    }

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
        typeText(fieldOne, "297777777");
        typeText(fieldTwo, "10");
        click(continueButton);
        WebElement iframe = driver.findElement(By.cssSelector("iframe.bepaid-iframe"));
        driver.switchTo().frame(iframe);
    }
}
