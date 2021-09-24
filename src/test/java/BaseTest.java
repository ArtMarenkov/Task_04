
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.TestService;



public class BaseTest {

    private TestService testService = new TestService();
    protected void getDriverBaseURL(){
        testService.getInitDriver().get(testService.getBaseURL());
    }

    @After
    public void tearDown() {
        testService.getInitDriver().quit();
        testService.resetDriver();
    }

    @Attachment(type = "image/png", value = "Скриншот при ошибке")
    public byte[] takeScreenShot(){
        return ((TakesScreenshot) new TestService().getInitDriver()).getScreenshotAs(OutputType.BYTES);
    }
}