package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class InformationSimulation {
    private String valorInversion;
    private String mantenerPlazo;
    private String plazo;
    private String recibirInteres;
}
