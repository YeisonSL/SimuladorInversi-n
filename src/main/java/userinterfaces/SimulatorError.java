package userinterfaces;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
@AllArgsConstructor
public class SimulatorError {

    public static final Target TEXT_VALOR_MINIMO = Target.the("Texto del valor minimo a invertir")
            .located(By.id("error-valor-minimo"));

    public static final Target TEXT_VALOR_MAXIMO = Target.the("Texto del valor maximo a invertir")
            .located(By.id("error-valor-maximo"));

    public static final Target TEXT_MES_MAXIMO = Target.the("Texto del valor maximo de mes permitidos")
            .located(By.id("error-meses-maximo"));

    public static final Target TEXT_MES_MINIMO = Target.the("Texto del valor minimo de meses permitidos")
            .located(By.id("error-meses-minimo"));
}
