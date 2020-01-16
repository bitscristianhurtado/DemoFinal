Feature: Un usuario ingresa a YouTube, para realizar varias acciones

  Este prueba se basa en observar como es la interaccion entre un usuario y pa
  pagina conocida como YouTube, en el cual es usuario va a realizar diferentes
  acciones como:
  - Iniciar Sesion
  - Cambiar Tema
  - Buscar y dar Like en el primer video en Tendencia
  - Buscar y agregar el segundo video en tendencias a la lista de ver mas tarde
  - Ver la biblioteca de YuoTube

  Background: Iniciar sesión
    Given  Que ramon ingresa a la pagina de inicio
    And ramon inicia sesión

  Scenario: Acceso e Interaccion con YouTube
    When ramon cambie el tema de YouTube
    And ramon abra tendencias y reprodusca el primer video
    And ramon abra tendencias y reprodusca el segundo video
    Then ramon deberia ver las acciones que ha hecho