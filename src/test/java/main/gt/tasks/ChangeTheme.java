package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class ChangeTheme {
    Actor actor;

    @Managed
    WebDriver navegador;


    @Before
    public void abrirNavegador() {
        actor = Actor.named("ramon");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    @When("^(.*) cambie el tema de YouTube$")
    public void cambiar_tema(String usuario) {

        //Abrir el menu, para empezar a cambiar el tema
        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " cliquee en el boton 'mi cuenta'",
                                "Boton my account",
                                "//button[@id='avatar-btn']"
                        )));

        //Seleccionar el boton cambiar tema
        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " cliquea el boton de cambiar tema",
                                "Boton cambiar tema",
                                "//ytd-toggle-theme-compact-link-renderer[@class='style-scope yt-multi-page-menu-section-renderer']"
                        )));

        //Comfirmar cambio de tema
        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " cliquea el boton de confirmar el cambio de tema",
                                "Boton comfirmar cambio",
                                "//div[@class='toggle-container style-scope paper-toggle-button']"
                        )));

        //Volver a pantalla principal
        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " cliquea en el boton salir de confirmacion",
                                "Salir de confirmacion",
                                "//ytd-button-renderer[@id='back-button']//yt-icon[@class='style-scope ytd-button-renderer']"
                        )));

        //Ver nuevo tema
        actor.should(
                new QuestionValidate(
                        "Recomendados").Execute(
                        new GeneralParams(
                                "Pagina Principal",
                                "//span[contains(text(),'Recomendados')]"
                        )));

    }
}
