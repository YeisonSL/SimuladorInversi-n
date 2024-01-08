package interactions;

import lombok.AllArgsConstructor;
import models.InformationSimulation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static userinterfaces.VirtualSimulator.*;
import static utilities.constants.Constants.YES;
import static utilities.constants.Constants.ZERO;

@AllArgsConstructor
public class SelectOptionKnowDeadline implements Interaction {

    private List<InformationSimulation> simulationData;

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (simulationData.get(0).getMantenerPlazo().equals(YES)){
            actor.attemptsTo(
                    Click.on(RADIO_BTN_SI),
                    Enter.theValue(simulationData.get(ZERO).getPlazo()).into(LBL_PLAZO)
            );
        }else {
            actor.attemptsTo(Click.on(RADIO_BTN_NO));
        }
    }

    public static SelectOptionKnowDeadline forType(List<InformationSimulation> simulationData) {
        return Tasks.instrumented(SelectOptionKnowDeadline.class, simulationData);
    }

}