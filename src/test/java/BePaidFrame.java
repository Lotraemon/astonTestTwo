import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BePaidFrame {
    By visaIcon = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/img[1]");
    By phoneNumber = By.xpath("//*[@class='pay-description__text']/span[1]");
    By placehder = By.xpath("//*[@class='card-page__card']//label[1]");
    //card-page__card
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public BePaidFrame(WebDriver driver) {
        this.driver = driver;
    }

    public String getPriceValue(){
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='pay-description__cost']/span[1]")));
        return priceElement.getText();
    }

    /*public String getPriceValue(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement priceElement = driver.findElement(By.xpath("//*[@class='pay-description__cost']/span[1]"));
        return  (String) js.executeScript("return arguments[0].textContent;", priceElement);
    }*/

    public String getPhoneNumber (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement numb = driver.findElement(By.xpath("//*[@class='pay-description__text']/span[1]"));
        return  (String) js.executeScript("return arguments[0].textContent;", numb);
    }
    public String getNumberPlaceholder (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement placeholder = driver.findElement(By.xpath("//*[@class='card-page__card']//label[1]"));
        return (String) js.executeScript("return arguments[0].textContent;", placeholder);
    }
    public String getPeriodPlaceholder (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement placeholder = driver.findElement(By.xpath("//*[@class='card-page__card']//div[2]//label"));
        return (String) js.executeScript("return arguments[0].textContent;", placeholder);
    }
    public String getCvcPlaceholder (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement placeholder = driver.findElement(By.xpath("//*[@class='card-page__card']//div[3]//label"));
        return (String) js.executeScript("return arguments[0].textContent;", placeholder);
    }
    public String getUsernamePlaceholder (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement placeholder = driver.findElement(By.xpath("//*[@class='ng-tns-c46-3 ng-star-inserted']"));
        return (String) js.executeScript("return arguments[0].textContent;", placeholder);
    }
    public String getButtonText (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(By.xpath("//*[@class='payment-page__container']//button"));
        return (String) js.executeScript("return arguments[0].textContent;", button);
    }
}
