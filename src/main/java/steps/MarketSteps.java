package steps;

import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketSteps extends BaseSteps{

    private MarketPage marketPage;

    public MarketSteps() {
        marketPage = new MarketPage(testService.getInitDriver());
    }

    @Step("нажатие на Электроника")
    public void stepElectonics() {
        marketPage.electronicsClick();
    }
}