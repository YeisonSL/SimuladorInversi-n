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
      | 1500000        | Si            | 30    | Al finalizar el plazo |


  @UnHappy_SimularIversionVirtual
  Esquema del escenario: Validar los errores al realizar una simulación de inversión virtual
    Cuando el usuario ingresa al portal de personas
    Y el usuario realiza una simulacion de "Inversion Virtual" con los datos:
      | valorInversion   | mantenerPlazo   | plazo   | recibirInteres   |
      | <valorInversion> | <mantenerPlazo> | <plazo> | <recibirInteres> |
    Entonces el usuario podra visualizar el mensaje de error "<mensaje>"
    Ejemplos:
      | valorInversion | mantenerPlazo | plazo | recibirInteres | mensaje                   |
      | 0              | Si            | 50    |                | monto minimo de inversion |
      | 49999          | Si            | 200   |                | monto minimo de inversion |
      | 80000          | No            | 29    |                | valor minimo de dias      |
      | 500000         | No            | 5     |                | valor minimo de dias      |
      | 50000000000    | Si            | 50    |                | monto maximo de inversion |
      | 500899         | Si            | 1801  |                | valor maximo de dias      |