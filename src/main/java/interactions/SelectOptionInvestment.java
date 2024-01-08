package interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;

import static userinterfaces.Investment.OPC_VIRTUAL_INVESTMENT;
import static utilities.constants.Constants.VIRTUAL_INVESTMENT;

@AllArgsConstructor
public class SelectOptionInvestment implements Interaction {

    private String typeInvestment;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Check.whether(typeInvestment.equals(VIRTUAL_INVESTMENT))
                        .andIfSo(Scroll.to(OPC_VIRTUAL_INVESTMENT))
                        .andIfSo(Click.on(OPC_VIRTUAL_INVESTMENT))
        );
    }

    public static SelectOptionInvestment forType(String typeInvestment) {
        return Tasks.instrumented(SelectOptionInvestment.class, typeInvestment);
    }

}
