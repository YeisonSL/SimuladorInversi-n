package interactions;

import lombok.AllArgsConstructor;
import models.InformationSimulation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;

import java.util.List;

import static userinterfaces.VirtualSimulator.*;
import static utilities.constants.Constants.*;

@AllArgsConstructor
public class SelectReceiveInterest implements Interaction {

    private List<InformationSimulation> simulationData;

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (simulationData.get(ZERO).getRecibirInteres() != null)
            actor.attemptsTo(
                    Scroll.to(BTN_SIMULAR),
                    Check.whether(simulationData.get(ZERO).getMantenerPlazo().equals(NO))
                            .andIfSo(Click.on(SELECT_VALUES)),
                    Check.whether(simulationData.get(ZERO).getRecibirInteres().equals(RECEIVEINTEREST))
                            .andIfSo(Click.on(SELECT_MENSUAL))
                            .otherwise(Click.on(SELECT_FINALIZAR_PLAZO))
            );
    }

    public static SelectReceiveInterest forType(List<InformationSimulation> simulationData) {
        return Tasks.instrumented(SelectReceiveInterest.class, simulationData);
    }

}
