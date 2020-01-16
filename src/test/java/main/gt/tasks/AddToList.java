package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class AddToList {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("ramon");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    @And("^(.*) abra tendencias y reprodusca el segundo video$")
    public void agregarSegundoVideoEnTendenciasAVerMasTarde(String usuario) throws InterruptedException {
        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " cliquea en el boton de tendencias",
                                "boton tendencias",
                                "//yt-formatted-string[contains(text(),'Tendencias')]"
                        )));
        Thread.sleep(2000);
        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " reproduce el segundo video en tendencias",
                                "link segundo video en tendencias",
                                "//ytd-item-section-renderer[1]//div[3]//ytd-shelf-renderer[1]//div[1]//div[2]//ytd-expanded-shelf-contents-renderer[1]//div[1]//ytd-video-renderer[2]//div[1]//div[1]//div[1]//div[1]//h3[1]//a[1]"
                        )));

        Thread.sleep(10000);
        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " cliquea en el boton de agregar a 'Ver mas tarde'",
                                "boton ver mas tarde",
                                "//div[@id='info']//ytd-button-renderer[2]"
                        )));

        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " comfirma agregar a la lista",
                                "Boton confirmar accion",
                                "//paper-checkbox[@id='checkbox']//div[@id='checkboxContainer']"
                        )));

        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " cierra la ventana de confirmacion",
                                "Boton cerra ventana de confirmacion",
                                "//div[@id='header']//yt-icon-button[@id='close-button']//button[@id='button']"
                        )));

        actor.attemptsTo(
                new ClickButtonAction().Execute(
                        new GeneralParams(
                                usuario + " vuelve a la pagina principal",
                                "Link home page",
                                "#logo"
                        )));
    }

}
