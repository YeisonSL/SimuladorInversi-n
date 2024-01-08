package userinterfaces;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
@AllArgsConstructor
public class VirtualSimulator {
    public static final Target BTN_CONTINUAR = Target.the("Botón ir al fomrularion del simulador")
            .located(By.id("boton-seleccion-tarjeta"));

    public static final Target LBL_MONTO_INVERTIR = Target.the("Campo para ingresar el monto a invertir")
            .located(By.id("valor-simulacion"));

    public static final Target RADIO_BTN_SI = Target.the("Opción de SI saber a qué plazo deseas mantenerlo")
            .located(By.cssSelector("[for='opcion-si-input'] .mat-radio-outer-circle"));

    public static final Target RADIO_BTN_NO = Target.the("Opción de NO saber a qué plazo deseas mantenerlo")
            .located(By.cssSelector("[for='opcion-no-input'] > .mat-radio-container"));

    public static final Target LBL_PLAZO = Target.the("Campo para ingresae el valor del plazo")
            .located(By.id("valor-plazo"));

    public static final Target SELECT_VALUES = Target.the("Opción para mostrar opciones del select")
            .located(By.cssSelector(".mat-select"));
    public static final Target SELECT_MENSUAL = Target.the("Select para selcionar opción mensaul")
            .located(By.xpath("//span[contains(.,'Mensualmente')]"));

    public static final Target SELECT_FINALIZAR_PLAZO = Target.the("Select para selcionar opción finalizar plazo")
            .located(By.cssSelector("[aria-selected='true'] > .mat-option-text"));

    public static final Target BTN_SIMULAR = Target.the("Botón para realizar simulación")
            .located(By.id("boton-simular"));

    public static final Target TEXT_INVERSION = Target.the("Text con el valor de la inversión")
            .located(By.cssSelector("#card-uno h5"));

    public static final Target TEXT_GANANCIAS = Target.the("Text con el valor de las ganacias")
            .located(By.id("resultado-tres"));

    public static final Target TEXT_DAYS = Target.the("Text con los días de la inversión")
            .located(By.cssSelector(".accent"));
}
