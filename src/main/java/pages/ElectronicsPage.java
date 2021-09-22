package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectronicsPage extends BasePage{

    private String category = "//li//a[text() = '%s']"; // //Путь к кнопкам категорий товаров

    public ElectronicsPage(WebDriver driver) {
        super(driver);

    }

    public void categoryClick(String categoryName) {
        driver.findElement(By.xpath(String.format(category, categoryName))).click();
    }

}
