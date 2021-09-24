package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsuranceSteps extends BaseSteps{

    private TravelInsurancePage travelInsurancePage;

    public TravelInsuranceSteps() {
        travelInsurancePage = new TravelInsurancePage(testService.getInitDriver());
    }

    @Step("нажатие на кнопку 'Оформить онлайн")
    public void stepTravelInsurance() {
        travelInsurancePage.checkout.click();
    }
}
