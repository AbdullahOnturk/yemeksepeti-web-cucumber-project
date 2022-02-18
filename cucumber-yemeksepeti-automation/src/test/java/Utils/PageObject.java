package Utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class PageObject {
    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriverWait getWebDriverWait() {
        wait = new WebDriverWait(driver, 30);
        return wait;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        return driver;
    }

    public void close() {
        if (driver != null) {
            driver.quit();
            driver.close();
            driver = null;
        }

    }
    public void getPage(String link) {
        getDriver().get(link);
    }

    public WebElement waitForElement(String el) {
        System.out.println(el+" elementinin varolması bekleniyor.");
        WebElement element = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(el)));
        return element;
    }
        public void waitUntilElementClickable(WebElement by) {
            System.out.println("Elementin tıklanabilir olması bekleniyor.");
            getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by));
        }


    public void onClickId(String id) {
        System.out.println(id + " alanın id'sine tıklama işlemina başlanır!!!");
        WebElement element = (WebElement) getDriver().findElement(By.id(id));
        if (!element.isDisplayed() && !element.isEnabled()) {
            Assert.fail(id + " -> Elementi bulunamadı!!!!!!!!!!!!!!");
        }
        try {
            waitUntilElementClickable(element);
        } catch (Exception ex) {
            Assert.fail(id + " -> Elementi tıklanabilir değil!");
        }
        element.click();
        System.out.println(id+"  xpath e tıklandı");

    }


    public void onClickXpath(String xpath) {
        System.out.println(xpath + " alanın xpath'ine tıklama işlemina başlanır!!!");
        WebElement element = (WebElement) getDriver().findElement(By.xpath(xpath));
       if (!element.isDisplayed() && !element.isEnabled()) {
            Assert.fail(xpath + " -> Elementi bulunamadı!!!!!!!!!!!!!!");
        }
        try {
            waitUntilElementClickable(element);

        } catch (Exception ex) {
            Assert.fail(xpath + " -> Elementi tıklanabilir değil!");
        }
        element.click();
        System.out.println(xpath+"  xpath e tıklandı");
    }


    public void sendKeysId(String id, String text) {
        System.out.println(id + " alanın xpath'ine tıklama işlemina başlanır!!!");
        WebElement element = (WebElement) getDriver().findElement(By.id(id));
        if (!element.isDisplayed() && !element.isEnabled()) {
            Assert.fail(id + " -> Elementi bulunamadı!!!!!!!!!!!!!!");
        }
        try {
            waitUntilElementClickable(element);
        } catch (Exception ex) {
            Assert.fail(id + " -> Elementi tıklanabilir değil!");
        }

        element.click();
        System.out.println(id+"  xpath e tıklandı");
        element.sendKeys(text);
        System.out.println(id+" alanına "+text+" değeri yazıldı.");
    }


    public void checkText(String id, String text) {
        Assert.assertEquals(waitForElement(id).getText(), text);
        System.out.println(id+" alanında : "+text+" yazdığı görüldü.");
    }
}
