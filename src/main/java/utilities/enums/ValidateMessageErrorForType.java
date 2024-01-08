package utilities.enums;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;

import java.util.Arrays;

import static userinterfaces.SimulatorError.*;
import static utilities.constants.Constants.USER;

@RequiredArgsConstructor
public enum ValidateMessageErrorForType {
    MAX_ALLOWED("El campo no cumple con el monto maximo ej: $10,000,000,000"){
        @Override
        public Boolean validateMessage(String messageError){
           boolean validation  =  messageError.equals(TEXT_VALOR_MAXIMO.resolveFor(Actor.named(USER)).getText())
                   ? true
                   : false;
            return validation;
        }
    },

    MIN_ALLOWED("El campo no cumple con el monto mínimo ej: $500,000"){
        @Override
        public Boolean validateMessage(String messageError){
            boolean validation  =  messageError.equals(TEXT_VALOR_MINIMO.resolveFor(Actor.named(USER)).getText())
                    ? true
                    : false;
            return validation;
        }
    },

    MIN_MONTH("El campo no cumple con el valor mínimo: 30 días"){
        @Override
        public Boolean validateMessage(String messageError){
            boolean validation = messageError.equals(TEXT_MES_MINIMO.resolveFor(Actor.named(USER)).getText())
                    ? true
                    : false;
            return validation;
        }
    },

    MAX_MONTH("El campo no cumple con el valor máximo: 1800 días"){
        @Override
        public Boolean validateMessage(String messageError){
            boolean validation = messageError.equals(TEXT_MES_MAXIMO.resolveFor(Actor.named(USER)).getText())
                    ? true
                    : false;
            return validation;
        }
    };

    public String getValue(){return validation;}

    private final String validation;

    public abstract Boolean validateMessage(String messageError);

    public static ValidateMessageErrorForType getValidation(String messageToEvaluate){
        return Arrays.stream(ValidateMessageErrorForType.values())
                .filter(message -> message.getValue().equals(messageToEvaluate))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No se encontro el mensaje a evaluar", messageToEvaluate)));
    }
}
