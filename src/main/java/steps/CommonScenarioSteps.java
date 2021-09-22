package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import util.TestService;

public class CommonScenarioSteps {

    TestService testService;

    private MainSteps mainSteps;
    private MarketSteps marketSteps;
    private ElectronicsSteps electronicsSteps;
    private CommonSteps commonSteps;
    private WebDriver driver;

    {
        testService = new TestService();
        driver = testService.getInitDriver();
        driver.get(testService.getBaseURL());
//        driver = testService.getInitDriver();
    }

    @When("^выбран сервис Маркет$")
    public void stepMarketMenu() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainSteps = new MainSteps();
        mainSteps.stepMarketMenu();
    }

    @When("^выбрана категория Электроника$")
    public void stepElectronic() {
        marketSteps = new MarketSteps();
        marketSteps.stepElectonics();
    }

    @When("^выбрана категория товаров =\"(.+)\"$")
    public void stepCategoryClick(String categoryName) {
        electronicsSteps = new ElectronicsSteps();
        electronicsSteps.stepCategoryClick(categoryName);
    }

    @When("^установлен фильтра по цене =\"(.+)\"$")
    public void setFilterStep(String menuItem) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonSteps = new CommonSteps();
        commonSteps.setFilter(menuItem);
    }

    @When("^установлен производитель =\"(.+)\"$")
    public void brandChoose(String brandName) {
        commonSteps.brandChoose(brandName);
    }

    @When("^количество элементов на странице\"(.+)\"$")
    public void checkItemsCount(int count) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonSteps.checkItemCount(count);
    }

    @Then("^наименование найденного товара соответствует запомненному значению$")
    public void checkFirstItemWithSearch() {
        commonSteps.checkFirstItem();
    }

    @After
    public void tearDown() {
        driver.quit();
        testService.resetDriver();
    }

}
