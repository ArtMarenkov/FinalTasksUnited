package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy (xpath = "//nav[@aria-label = 'Сервисы']")   // Общее верхнее меню
    WebElement mainMenu;

        public MainPage(WebDriver driver) {
            super(driver);
    }

    public void selectMarketMenu() {
        mainMenu.findElement(By.xpath("//a[@data-statlog = 'services_new.item.market.0']")).click();  // Нажатие на "Маркет"
        //mainMenu.findElement(By.xpath("//div[@class = 'services-new__icon services-new__promo-icon-default']")).click();  // Нажатие на "Маркет"
    }

}
