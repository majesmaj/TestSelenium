package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrontPage {
    WebDriver driver;
    By signIn = By.className("login");

    public FrontPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSignIn(){
        driver.findElement(signIn).click();
    }
}
