package main.gt.tasks;


import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.actions.OpenUrlAction;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class SingIn {

    Actor actor;

    @Managed
    WebDriver navegador;


    @Given("^Que (.*) ingresa a la pagina de inicio$")
    public void ingresarAUrl(String usuario) {
        actor = Actor.named(usuario);
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "http://youtube.com/")));

    }

    @And("^(.*) inicia sesión$")
    public void iniciarSesion(String usuario) {
        actor.attemptsTo(
                new ClickButtonAction().Execute(new GeneralParams(
                        usuario + " da click en el boton 'Acceder'.",
                        "Boton acceder a cuenta",
                        "//ytd-button-renderer[@class='style-scope ytd-masthead style-suggestive size-small']//paper-button[@id='button']"
                )));

        actor.attemptsTo(new EnterTextAction("pepitoquieregalletas").Execute(new GeneralParams(
                usuario + " ingresa su correo en el campo",
                "Campo email",
                "//input[@id='identifierId']"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                usuario + " selecciona siguiente",
                "Boton validar correo",
                "#identifierNext"
        )));


        actor.attemptsTo(new EnterTextAction("prueba$999").Execute(
                new GeneralParams(
                        usuario + " ingresa texto en un campo clave",
                        "Campo clave",
                        "//input[@name='password']"
                )
        ));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                usuario + " da en el boton siguiente",
                "Boton finalizar",
                "#passwordNext"
        )));
    }


}
