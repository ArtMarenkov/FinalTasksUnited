package util;

import gherkin.formatter.model.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.MakeAttachmentEvent;



public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {
    @Override
    public void result(Result result) {
        if ("failed".equals(result.getStatus())) takeScreenshot(result);
        super.result(result);
    }


    public void takeScreenshot(Result step) {
        TestService testService = new TestService();

        if (testService.getInitDriver() != null) {
            Allure.LIFECYCLE.fire(new MakeAttachmentEvent(((TakesScreenshot)testService.getInitDriver()).getScreenshotAs(OutputType.BYTES),
                    "Скриншот в момент ошибки", "image/png"));
        }
    }
}
