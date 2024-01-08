package stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import models.InformationSimulation;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Map;

public class MainSteps {
    @Given("^que \"(.*)\" quiere(?:n|) (?:.*)$")
    public void youWantToBeBancolombiaCustomer(String actor) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor(actor);
    }

    @DataTableType
    public InformationSimulation entry(Map<String, String> entry) {
        return new InformationSimulation(
                entry.get("valorInversion"),
                entry.get("mantenerPlazo"),
                entry.get("plazo"),
                entry.get("recibirInteres")
        );

    }

}

