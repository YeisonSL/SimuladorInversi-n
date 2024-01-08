package stepdefinitions;

import questions.ValidateMessageError;
import utilities.enums.Portal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.InformationSimulation;
import net.serenitybdd.screenplay.actions.Open;
import questions.ValidateReport;
import tasks.CreateExcelReport;
import tasks.SimulateVirtualInvestment;
import utilities.enums.ValidateMessageErrorForType;

import java.util.List;

import static utilities.enums.MensajeConfirmacion.CONFIRMATION_MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static userinterfaces.VirtualSimulator.*;
import static utilities.constants.Constants.USER;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;
import static utilities.enums.MensajeConfirmacion.ERROR_MESSAGE;

public class VirtualInvestmentSimulatorSteps {

    @When("el usuario ingresa al portal de personas")
    public void accessThePeoplePortal() {
        theActor(USER).wasAbleTo(Open.url(Portal.PERSONAS_BANCOLOMBIA.getPortal()));
    }

    @And("el usuario realiza una simulacion de {string} con los datos:")
    public void investmentSimulationIsPerformed(String typeInvestment, List<InformationSimulation> simulationData) {
        theActor(USER).attemptsTo(SimulateVirtualInvestment.withData(typeInvestment, simulationData));
    }

    @Then("el cliente podra visualizar los datos de la presetnacion agendada")
    public void clientWillBeAbleToViewTheResults() {

        theActor(USER).attemptsTo(
                CreateExcelReport.withData(
                        TEXT_INVERSION.resolveFor(theActor(USER)).getText(),
                        TEXT_GANANCIAS.resolveFor(theActor(USER)).getText(),
                        TEXT_DAYS.resolveFor(theActor(USER)).getText()
                )
        );

        theActor(USER)
                .should(
                        seeThat(CONFIRMATION_MESSAGE.getMensaje(),
                                ValidateReport.created(TEXT_INVERSION.resolveFor(theActor(USER)).getText()),
                                equalTo(true)
                        ));
    }

    @Then("el usuario podrá visualizar lel mensaje de error {string}")
    public void errorMessagesDisplayed(String messageError) {
        theActor(USER)
                .should(
                        seeThat(ERROR_MESSAGE.getMensaje(),
                                ValidateMessageError.forType(messageError),
                                equalTo(true)
                        ));
    }

}
