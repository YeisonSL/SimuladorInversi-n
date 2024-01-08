#language: es
Característica: Programar una presentación de proyecto
  Yo como usuario del millon and up
  Necesito realizar la programación de presentación de proyecto en el portal web
  Para tener una agenda de presentación

  Antecedentes:
    Dado que "Yeison" quiere simular una inversión virtual

  @Happy_Simulacion_Virtual
  Esquema del escenario: Validar que un usuario pueda programar una presentación de proyecto por zoom
    Cuando el usuario ingresa al portal de personas
    Y el usuario realiza una simulacion de "Inversion Virtual" con los datos:
      | valorInversion   | mantenerPlazo   | plazo   | recibirInteres   |
      | <valorInversion> | <mantenerPlazo> | <plazo> | <recibirInteres> |
    Entonces el cliente podra visualizar los datos de la presetnacion agendada

    Ejemplos:
      | valorInversion | mantenerPlazo | plazo | recibirInteres        |
      | 500000         | No            | 50    | Al finalizar el plazo |
      | 10000000000    | Si            | 200   | Al finalizar el plazo |
      | 800000         | No            | 1800  | Mensualmente          |
      | 1500000        | No            | 30    | Al finalizar el plazo |


  @UnHappy_SimularIversionVirtual
  Esquema del escenario: Validar los errores al realizar una simulación de inversión virtual
    Cuando el usuario ingresa al portal de personas
    Y el usuario realiza una simulacion de "Inversion Virtual" con los datos:
      | valorInversion   | mantenerPlazo   | plazo   | recibirInteres   |
      | <valorInversion> | <mantenerPlazo> | <plazo> | <recibirInteres> |
    Entonces el usuario podrá visualizar lel mensaje de error "<mensaje>"
    Ejemplos:
      | valorInversion | mantenerPlazo | plazo | recibirInteres | mensaje                                                    |
      | 0              | Si            | 50    |                | El campo no cumple con el monto mínimo ej: $500,000        |
      | 49999          | Si            | 200   |                | El campo no cumple con el monto mínimo ej: $500,000        |
      | 80000          | No            | 29    |                | El campo no cumple con el valor mínimo: 30 días            |
      | 500000         | No            | 5     |                | El campo no cumple con el valor mínimo: 30 días            |
      | 50000000000    | Si            | 50    |                | El campo no cumple con el monto maximo ej: $10,000,000,000 |
      | 500899         | Si            | 1801  |                | El campo no cumple con el valor máximo: 1800 días          |