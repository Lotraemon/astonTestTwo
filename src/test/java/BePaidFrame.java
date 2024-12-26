import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BePaidFrame {
    By iFramee = By.cssSelector("iframe.bepaid-iframe");
    By costValue = By.xpath("//*[@class='pay-description__cost']/span");
    private final WebDriver driver;

    public BePaidFrame(WebDriver driver) {
        this.driver = driver;
    }
    public String checkCostValue (){
        return driver.findElement(costValue).getText();
    }

    public BePaidFrame switchFrame (){
         WebElement webElement = driver.findElement(iFramee);
         return this;
    }
}
