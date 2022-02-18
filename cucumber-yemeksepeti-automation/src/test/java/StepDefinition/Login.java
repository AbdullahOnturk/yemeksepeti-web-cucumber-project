package StepDefinition;


import Utils.PageObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends PageObject{

    @Given("^\"([^\"]*)\" web sitesi açılır!!!!!!!!$")
    public void onPage(String link) {
        System.out.println("sayfa açıldı");
        getPage(link);
    }

    @When("^\"([^\"]*)\" id sine tıklanır.")
    public void idClick(String id) {
        System.out.println(id+" id ye tıklandı");
        onClickId(id);
    }

    @When("^\"([^\"]*)\" xpath ine tıklanır.")
    public void xpathClick(String xpath) {
        onClickXpath(xpath);
    }

    @When("^\"([^\"]*)\" id alanına \"([^\"]*)\" yazılır.")
    public void idSetText(String id, String text){
        System.out.println(id+" alanına "+text+" değeri yazılır.");
        sendKeysId(id,text);
    }

    @Then("^\"([^\"]*)\" element alanında \"([^\"]*)\" yazdığı kontrol edilir.")
    public void check(String element, String text) {
        System.out.println(element+" alanına "+text+" değeri yazıldığı kontrol edilir.");
        checkText(element,text);
    }

}
