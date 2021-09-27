package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CommonPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'tamef']") // Путь к общему содержимому формы
    public WebElement mainform;

    @FindBy(xpath = "//button//span[contains(text(),'48')]") //Путь к полю количества элементов к выдаче
    public WebElement shownItems;

    @FindBy(xpath = "//article")
    public List<WebElement> countShownItems;

    @FindBy(xpath = "//article[1]")
    public WebElement firstElement;

    @FindBy(xpath = "//article[1]//a/span")
    public WebElement firstElementName;

    @FindBy(xpath = "//input[@id = 'header-search']")
    public WebElement searchRow;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement searchButton;

    @FindBy(xpath = "(//div[@data-zone-name = 'snippetList']/article)[1]")
    public WebElement firstElementAfterSearch;

    @FindBy(css = "input[id='glpricefrom']") // //Путь к полю "Цена от"
    WebElement pricefrom; // цена от

    @FindBy(xpath = "//input[@name = 'Поле поиска']")
    WebElement searchField;

    @FindBy(xpath = "(//button[text() = 'Показать всё'])[1]")
    // путь к кнопке "Показать все" в разделе Производитель
    public WebElement showAllBrands;

    private String brand = "//div/span[text() = '%s']"; //Путь к полю производитель

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public int getCountItems() {
        return countShownItems.size();
    }

    public String getFirstElementName() {
        return firstElementName.getText();
    }

    public void search(String text) {
        searchRow.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void setFilter(String price) {
        pricefrom.sendKeys(price);
    }

    public void setShowAllBrands() {
        if (showAllBrands.isDisplayed()){
            showAllBrands.click();
        }
    }

    public void searchField(String brandName) {
        searchField.clear();
        searchField.sendKeys(brandName);
    }

    public String getActualFirstElementName() {
        String text0 = firstElementAfterSearch.findElements(By.xpath(".//a[@title]/span")).stream().map(element -> element.getText()).collect(Collectors.joining());
        return text0;
    }

    public void brandClick(String brandName) {//Выбор производителя
        driver.findElement(By.xpath(String.format(brand, brandName))).click();
    }
}
