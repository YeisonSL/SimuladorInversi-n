package userinterfaces;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
@AllArgsConstructor
public class VirtualInvestment {

    public static final Target BTN_SIMULAR_INVERSION = Target.the("Boton para ingresar al simulador")
            .located(By.cssSelector(".bann-desk [href='/personas/productos-servicios/inversiones/cdts/inversion-virtual/simulador-inversion-virtual']"));
}
