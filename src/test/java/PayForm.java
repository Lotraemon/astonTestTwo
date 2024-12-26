import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayForm {
    By numberField = By.xpath("//*[@class='pay-form opened']/div[1]/input");
    By payValueField = By.xpath("//*[@class='pay-form opened']/div[2]/input");
    By emailField = By.xpath("//*[@class='pay-form opened']/div[3]/input");
    By aboutService =  By.linkText("Подробнее о сервисе");
    By logos = By.xpath("//*[@class='pay__wrapper']//img");
    By title = By.xpath("//*[@class='pay__wrapper']/h2");

    private final WebDriver driver;

    public PayForm(WebDriver driver) {
        this.driver = driver;
    }

    public PayForm checkNumberPlaceholder(String placeholder) {
        Assertions.assertEquals(placeholder,driver.findElement(numberField).getAttribute("placeholder"));
        return this;
    }
    public PayForm checkPayValuePlaceholder(String placeholder) {
        driver.findElement(payValueField).getAttribute("placeholder");
        return this;
    }
    public PayForm checkEmailPlaceholder(String placeholder) {
        driver.findElement(emailField).getAttribute("placeholder");
        return this;
    }


}
