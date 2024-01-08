package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.*;

@AllArgsConstructor
public class ValidateReport implements Question<Boolean> {

    private String investment;
    @Override
    public Boolean answeredBy(Actor actor) {
        File file = new File(String.format("src/test/resources/report/simulador%s.xls", investment));
        boolean validation = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            validation = br.readLine() == null
                    ? false
                    : true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return validation;
    }

    public static ValidateReport created(String  investment) {
        return new ValidateReport(investment);
    }
}