
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BePaid {
    By priceValue = By.xpath("//*[@class='pay-description__cost']/span[1]");
    By phoneNumber = By.xpath("//*[@class='pay-description__text']/span[1]");
    By numberPlaceholder = By.xpath("//*[@class='card-page__card']//label[1]");
    By periodPlaceholder = By.xpath("//*[@class='card-page__card']//div[2]//label");
    By cvcPlaceholder = By.xpath("//*[@class='card-page__card']//div[3]//label");
    By usernamePlaceholder = By.xpath("//*[@class='ng-tns-c46-3 ng-star-inserted']");
    By button = By.xpath("//*[@class='payment-page__container']//button");
    By visaIcon = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/img[1]");
    By mastercardIcon = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/img[2]");
    By belkartIcon = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/img[3]");
    By mirIcon1 = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/div/img[1]");
    By mirIcon2 = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/div/img[2]");

    private WebDriver driver;

    public BePaid(WebDriver driver) {
        this.driver = driver;
    }

    public String getText(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

    public boolean isIconVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.isDisplayed();
    }

}
