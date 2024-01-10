package tasks;

import interactions.SelectOptionInvestment;
import interactions.SwitchToNewWindow;
import lombok.AllArgsConstructor;
import models.InformationSimulation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.HomePeople.LI_INVERSIONES;
import static userinterfaces.HomePeople.LI_PRODCTOS_SERVICIOS;
import static userinterfaces.VirtualInvestment.BTN_SIMULAR_INVERSION;
import static userinterfaces.VirtualSimulator.BTN_SIMULAR;
import static utilities.constants.Constants.*;

@AllArgsConstructor
public class SimulateVirtualInvestment implements Task {

    private String typeInvestment;
    private List<InformationSimulation> simulationData;

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
               Click.on(LI_PRODCTOS_SERVICIOS),
               Click.on(LI_INVERSIONES),
               SelectOptionInvestment.forType(typeInvestment),
               //Switch.toWindow(TITLE_VIRTUAL_INVESTMENT),
               SwitchToNewWindow.change(),
               WaitUntil.the(BTN_SIMULAR_INVERSION, WebElementStateMatchers.isVisible()),
               Scroll.to(BTN_SIMULAR_INVERSION),
               net.serenitybdd.screenplay.actions.Click.on(BTN_SIMULAR_INVERSION),
               //Switch.toWindow(TITLE_SIMULATOR))
               SwitchToNewWindow.change(),
               EnterSimulationInformation.data(simulationData)
       );

        if (simulationData.get(ZERO).getRecibirInteres() != null)
            actor.attemptsTo(Click.on(BTN_SIMULAR));
    }

    public static SimulateVirtualInvestment withData(String typeInvestment, List<InformationSimulation> simulationData) {
        return instrumented(SimulateVirtualInvestment.class, typeInvestment, simulationData);
    }

}