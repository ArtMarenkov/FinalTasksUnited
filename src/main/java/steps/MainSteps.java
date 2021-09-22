package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {
    private MainPage mainPage;

    public MainSteps() {
        mainPage = new MainPage(testService.getInitDriver());
    }

    @Step("Нажатие на Маркет")
    public void stepMarketMenu() {
        mainPage.selectMarketMenu();
    }
}
