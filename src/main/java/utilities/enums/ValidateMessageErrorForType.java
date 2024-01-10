package utilities.enums;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static userinterfaces.SimulatorError.*;
import static utilities.constants.Constants.*;

@RequiredArgsConstructor
public enum ValidateMessageErrorForType {
    MAX_ALLOWED("monto maximo de inversion"){
        @Override
        public Boolean validateMessage(Actor actor){
           boolean validation  =  ERROR_MESSAGE_MAX_ALLOWED.equals(TEXT_VALOR_MAXIMO.resolveFor(actor).getText())
                   ? true
                   : false;
            return validation;
        }
    },

    MIN_ALLOWED("monto minimo de inversion"){
        @Override
        public Boolean validateMessage(Actor actor){
            boolean validation  =  new String(ERROR_MESSAGE_MIN_ALLOWED).getBytes(StandardCharsets.UTF_8).equals(TEXT_VALOR_MINIMO.resolveFor(actor).getText())
                    ? true
                    : false;
            return validation;
        }
    },

    MIN_MONTH("valor minimo de dias"){
        @Override
        public Boolean validateMessage(Actor actor){
            boolean validation = ERROR_MESSAGE_MIN_MONTH.equals(TEXT_MES_MINIMO.resolveFor(actor).getText())
                    ? true
                    : false;
            return validation;
        }
    },

    MAX_MONTH("valor maximo de dias"){
        @Override
        public Boolean validateMessage(Actor actor){
            boolean validation = ERROR_MESSAGE_MAX_MONTH.equals(TEXT_MES_MAXIMO.resolveFor(actor).getText())
                    ? true
                    : false;
            return validation;
        }
    };

    public String getValue(){return validation;}

    private final String validation;

    public abstract Boolean validateMessage(Actor actor);

    public static ValidateMessageErrorForType getValidation(String messageToEvaluate){
        return Arrays.stream(ValidateMessageErrorForType.values())
                .filter(message -> message.getValue().contains(messageToEvaluate))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No se encontro el mensaje a evaluar", messageToEvaluate)));
    }
}
