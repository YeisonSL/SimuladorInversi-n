package tasks;

import interactions.SelectOptionKnowDeadline;
import interactions.SelectReceiveInterest;
import lombok.AllArgsConstructor;
import models.InformationSimulation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static userinterfaces.VirtualSimulator.BTN_CONTINUAR;
import static userinterfaces.VirtualSimulator.LBL_MONTO_INVERTIR;
import static utilities.constants.Constants.ZERO;

@AllArgsConstructor
public class EnterSimulationInformation implements Task {

    private List<InformationSimulation> simulationData;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_CONTINUAR),
                Enter.theValue(simulationData.get(ZERO).getValorInversion()).into(LBL_MONTO_INVERTIR),
                SelectOptionKnowDeadline.forType(simulationData),
                SelectReceiveInterest.forType(simulationData)
        );
    }

    public static EnterSimulationInformation data(List<InformationSimulation> simulationData) {
        return Tasks.instrumented(EnterSimulationInformation.class, simulationData);
    }

}
