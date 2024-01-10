package utilities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageConfirmation {

    CONFIRMATION_MESSAGE("La validacion del archivo creado no vacio es: "),
    ERROR_MESSAGE("La validacion del mensaje de error es: ");

    String mensaje;

}
