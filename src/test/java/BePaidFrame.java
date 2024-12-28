
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BePaidFrame {

    By phoneNumber = By.xpath("//*[@class='pay-description__text']/span[1]");
    By placeholder = By.xpath("//*[@class='card-page__card']//label[1]");

    private final WebDriver driver;

    public BePaidFrame(WebDriver driver) {
        this.driver = driver;
    }

    public String getPriceValue() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement priceElement = driver.findElement(By.xpath("//*[@class='pay-description__cost']/span[1]"));
        return (String) js.executeScript("return arguments[0].textContent;", priceElement);
    }

    public String getPhoneNumber() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement numb = driver.findElement(By.xpath("//*[@class='pay-description__text']/span[1]"));
        return (String) js.executeScript("return arguments[0].textContent;", numb);
    }

    public String getNumberPlaceholder() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement placeholder = driver.findElement(By.xpath("//*[@class='card-page__card']//label[1]"));
        return (String) js.executeScript("return arguments[0].textContent;", placeholder);
    }

    public String getPeriodPlaceholder() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement placeholder = driver.findElement(By.xpath("//*[@class='card-page__card']//div[2]//label"));
        return (String) js.executeScript("return arguments[0].textContent;", placeholder);
    }

    public String getCvcPlaceholder() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement placeholder = driver.findElement(By.xpath("//*[@class='card-page__card']//div[3]//label"));
        return (String) js.executeScript("return arguments[0].textContent;", placeholder);
    }

    public String getUsernamePlaceholder() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement placeholder = driver.findElement(By.xpath("//*[@class='ng-tns-c46-3 ng-star-inserted']"));
        return (String) js.executeScript("return arguments[0].textContent;", placeholder);
    }

    public String getButtonText() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(By.xpath("//*[@class='payment-page__container']//button"));
        return (String) js.executeScript("return arguments[0].textContent;", button);
    }
}
