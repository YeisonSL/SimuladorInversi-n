package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import utilities.enums.ValidateMessageErrorForType;

@AllArgsConstructor
public class ValidateMessageError implements Question<Boolean> {

    private String messageError;
    @Override
    public Boolean answeredBy(Actor actor) {
       return ValidateMessageErrorForType.getValidation(messageError).validateMessage(messageError);
    }

    public static ValidateMessageError forType(String  messageError) {
        return new ValidateMessageError(messageError);
    }
}