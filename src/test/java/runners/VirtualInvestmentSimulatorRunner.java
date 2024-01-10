package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "stepdefinitions",
        features = "src/test/resources/features/realizar_simulacion_virtual.feature",
        tags = "@UnHappy_SimularIversionVirtual" ,
        snippets = SnippetType.CAMELCASE,
        monochrome = true
)

public class VirtualInvestmentSimulatorRunner {

}
