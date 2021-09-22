package steps;

import pages.ElectronicsPage;
import ru.yandex.qatools.allure.annotations.Step;


public class ElectronicsSteps extends BaseSteps {

    private ElectronicsPage electronicsPage;

    public ElectronicsSteps() {
        electronicsPage = new ElectronicsPage(testService.getInitDriver());
    }

    @Step("выбор категории товара")
    public void stepCategoryClick(String categoryName) {
        electronicsPage.categoryClick(categoryName);
    }
}
