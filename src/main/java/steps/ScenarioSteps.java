package steps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import util.TestService;

import java.util.Map;

public class ScenarioSteps {

    private TestService testService;
    private WebDriver driver;

    {
        testService = new TestService();
        driver = testService.getInitDriver();
        driver.get(testService.getBaseURL());

    }

    private MainSteps mainSteps;
    private InsuranceSteps_2 insuranceSteps_2;

    @When("^выбран пункт меню \"(.+)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps = new MainSteps();
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран пункт меню -\"(.+)\"$")
    public void stepSelectSubMenu(String menuItem) {
        mainSteps.stepSelectSubMenu(menuItem);
    }

    @When("^нажатие на кнопку Оформить онлайн$")
    public void stepTravelInsurance() {
        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
        travelInsuranceSteps.stepTravelInsurance();
    }

    @When("^нажатие на кнопку Оформить$")
    public void stepCheckoutInsurance() {
        InsuranceSteps_1 insuranceSteps_1 = new InsuranceSteps_1();
        insuranceSteps_1.stepCheckoutInsurance();
    }

    @When("заполняются поля:")
    public void stepFillInsuranceFields(DataTable fields) {
        insuranceSteps_2 = new InsuranceSteps_2();
        Map<String, String> rows = fields.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : rows.entrySet()) {
            insuranceSteps_2.stepFillInsuranceField(entry.getKey(), entry.getValue());
        }

    }

    @When("^нажатие на кнопку Продолжить$")
    public void stepClickContinueButton() {
        insuranceSteps_2.stepClickContinueButton();
    }

    @Then("^выводится сообщение:\"(.+)\"$")
    public void stepCheckFieldErrorMessage(String error) {
        insuranceSteps_2.stepCheckFieldErrorMessage(error);
    }

    @After
    public void tearDown() {
        testService.getInitDriver().quit();
        testService.resetDriver();
    }

}
