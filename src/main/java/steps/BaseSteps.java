package steps;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.TestService;


public class BaseSteps {

    protected TestService testService = new TestService();

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        TestService testService = new TestService();

        return ((TakesScreenshot) testService.getInitDriver()).getScreenshotAs(OutputType.BYTES);
    }

}