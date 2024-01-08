package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePeople {

    private HomePeople() {
    }

    public static final Target LI_PRODCTOS_SERVICIOS = Target.the("Opción del menu para despelgar Productos y servicios")
            .located(By.id("menu-productos"));

    public static final Target LI_INVERSIONES = Target.the("Opción para ingresar a Inversiones")
            .located(By.id("header-productos-inversiones"));

}
