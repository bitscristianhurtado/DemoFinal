package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class YouTubeLibrary {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("ramon");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    @Then("^(.*) deberia ver las acciones que ha hecho$")
    public void observarBibliotecaYouTube(String usuario) throws InterruptedException {

        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " abra la biblioteca de YouTube",
                                "Boton abrir biblioteca",
                                "//ytd-guide-entry-renderer[@id='header-entry']//a[@id='endpoint']"
                        )));

        Thread.sleep(5000);
        actor.should(
                new QuestionValidate(
                        "Ver más tarde").Execute(
                        new GeneralParams(
                                "Videos Agregados a ver mas tarde",
                                "//span[contains(text(),'Ver más tarde')]"
                        )));

        actor.should(
                new QuestionValidate(
                        "Videos que me gustan").Execute(
                        new GeneralParams(
                                "Videos que el usuario le dio me gusta",
                                "//span[contains(text(),'Videos que me gustan')]"
                        )));
    }

}
