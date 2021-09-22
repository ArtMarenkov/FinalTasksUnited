package steps;

import org.junit.Assert;
import pages.CommonPage;
import ru.yandex.qatools.allure.annotations.Step;

public class CommonSteps extends BaseSteps {

    private CommonPage commonPage;

    public CommonSteps() {
        commonPage = new CommonPage(testService.getInitDriver());
    }

    @Step
    public void setFilter(String price) {
        commonPage.setFilter(price);
    }

    @Step
    public void checkItemCount (int count) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(count,commonPage.getCountItems());
    }

    @Step
    public void checkFirstItem () {
        String name = commonPage.getFirstElementName();
        commonPage.search(name);
        commonPage.clickSearchButton();
        String expected = name.replaceAll("\\s+","");
        String actual = commonPage.getActualFirstElementName().replaceAll("\\s+","");
        //Assertions.assertEquals(expected, actual);
        Assert.assertEquals(expected, actual);

    }

    @Step
    public void brandChoose(String brandName) {
        commonPage.brandClick(brandName);
    }
}
