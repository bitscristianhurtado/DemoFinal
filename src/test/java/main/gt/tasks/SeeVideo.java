package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;


public class SeeVideo {
    Actor actor;
    private Boolean isVisible;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("ramon");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    @And("^(.*) abra tendencias y reprodusca el primer video$")
    public void verPrimerVideoEnTendencias(String usuario) throws InterruptedException {
        Thread.sleep(1000);
        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(usuario + " cliquea en el boton de tendencias",
                                "boton tendencias",
                                "//yt-formatted-string[contains(text(),'Tendencias')]"
                        )));
        Thread.sleep(1000);
        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " cliquea en el rpimer video en tendencias",
                                "Link primer video",
                                "//ytd-browse[@class='style-scope ytd-page-manager']//ytd-video-renderer[1]//div[1]//div[1]//div[1]//div[1]//h3[1]//a[1]"
                        )));

        Thread.sleep(10000);

        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " da click en el boton de 'Me gusta'",
                                "Boton Me Gusta",
                                "//ytd-toggle-button-renderer[1]//a[1]//yt-icon-button[1]"
                        )));
        Thread.sleep(1000);
        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " da click en el logo de YouTube para volver a la pagina principal",
                                "Volver a home page",
                                "#logo"
                        )));
    }
}

