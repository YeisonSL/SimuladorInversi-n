package userinterfaces;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
@AllArgsConstructor
public class Investment {
    public static final Target OPC_VIRTUAL_INVESTMENT = Target.the("Opcion para ingresar a inversion virtual")
            .located(By.xpath("//div[@class=' row-fluid']//div[@class='leer-mas']/a[@href='/personas/productos-servicios/inversiones/inversion-virtual/']"));
}
