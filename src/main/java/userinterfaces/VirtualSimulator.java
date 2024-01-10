package userinterfaces;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
@AllArgsConstructor
public class VirtualSimulator {
    public static final Target BTN_CONTINUAR = Target.the("Boton ir al fomrularion del simulador")
            .located(By.id("boton-seleccion-tarjeta"));

    public static final Target LBL_MONTO_INVERTIR = Target.the("Campo para ingresar el monto a invertir")
            .located(By.id("valor-simulacion"));

    public static final Target RADIO_BTN_SI = Target.the("Opcion de SI saber a que plazo deseas mantenerlo")
            .located(By.cssSelector("[for='opcion-si-input'] .mat-radio-outer-circle"));

    public static final Target RADIO_BTN_NO = Target.the("Opcion de NO saber a que plazo deseas mantenerlo")
            .located(By.cssSelector("[for='opcion-no-input'] > .mat-radio-container"));

    public static final Target LBL_PLAZO = Target.the("Campo para ingresar el valor del plazo")
            .located(By.id("valor-plazo"));

    public static final Target SELECT_VALUES = Target.the("Opcion para mostrar opciones del select")
            .located(By.cssSelector(".mat-select"));
    public static final Target SELECT_MENSUAL = Target.the("Select para selcionar opcion mensaual")
            .located(By.xpath("//span[contains(.,'Mensualmente')]"));

    public static final Target SELECT_FINALIZAR_PLAZO = Target.the("Select para selcionar opcion finalizar plazo")
            .located(By.cssSelector("[aria-selected='true'] > .mat-option-text"));

    public static final Target BTN_SIMULAR = Target.the("Boton para realizar simulacion")
            .located(By.id("boton-simular"));

    public static final Target TEXT_INVERSION = Target.the("Text con el valor de la inversion")
            .located(By.cssSelector("#card-uno h5"));

    public static final Target TEXT_GANANCIAS = Target.the("Text con el valor de las ganacias")
            .located(By.id("resultado-tres"));

    public static final Target TEXT_DAYS = Target.the("Text con los dias de la inversion")
            .located(By.cssSelector(".accent"));
}
