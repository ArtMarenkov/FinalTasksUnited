package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class MarketPage extends BasePage{

    @FindBy(xpath = "//a[@href = '/catalog--elektronika/54440']") //Путь к кнопке "Электроника"
    public WebElement electronics;

    public MarketPage(WebDriver driver) {
        super(driver);
    }

    public void electronicsClick() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs2.get(tabs2.size()-1));

        electronics.findElement(By.xpath("//a[@href = '/catalog--elektronika/54440']"));
        electronics.click();
    }

}
