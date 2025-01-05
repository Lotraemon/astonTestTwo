
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BePaid {
    private By priceValue = By.xpath("//*[@class='pay-description__cost']/span[1]");
    private By phoneNumber = By.xpath("//*[@class='pay-description__text']/span[1]");
    private By numberPlaceholder = By.xpath("//*[@class='card-page__card']//label[1]");
    private By periodPlaceholder = By.xpath("//*[@class='card-page__card']//div[2]//label");
    private By cvcPlaceholder = By.xpath("//*[@class='card-page__card']//div[3]//label");
    private By usernamePlaceholder = By.xpath("//*[@class='ng-tns-c46-3 ng-star-inserted']");
    private By button = By.xpath("//*[@class='payment-page__container']//button");
    private By visaIcon = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/img[1]");
    private By mastercardIcon = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/img[2]");
    private By belkartIcon = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/img[3]");
    private By mirIcon1 = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/div/img[1]");
    private By mirIcon2 = By.xpath("//*[@class='cards-brands ng-tns-c46-1']/div/div/img[2]");

    public By getPriceValue() {
        return priceValue;
    }

    public By getPhoneNumber() {
        return phoneNumber;
    }

    public By getNumberPlaceholder() {
        return numberPlaceholder;
    }

    public By getPeriodPlaceholder() {
        return periodPlaceholder;
    }

    public By getCvcPlaceholder() {
        return cvcPlaceholder;
    }

    public By getUsernamePlaceholder() {
        return usernamePlaceholder;
    }

    public By getButton() {
        return button;
    }

    public By getVisaIcon() {
        return visaIcon;
    }

    public By getMastercardIcon() {
        return mastercardIcon;
    }

    public By getBelkartIcon() {
        return belkartIcon;
    }

    public By getMirIcon1() {
        return mirIcon1;
    }

    public By getMirIcon2() {
        return mirIcon2;
    }

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
