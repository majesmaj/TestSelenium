package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By Username = By.id("email");
    By Password = By.id("passwd");
    By LoginButton = By.name("SubmitLogin");
    By SignOutButton = By.className("logout");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String myLogin){
        driver.findElement(Username).sendKeys(myLogin);
    }

    public void setPassword(String myPassword){
        driver.findElement(Password).sendKeys(myPassword);
    }

    public void clickLogin(){
        driver.findElement(LoginButton).click();
    }

    public void clickSignOut(){
        driver.findElement(SignOutButton).click();
    }

    public void accountLogin(String myLogin,String myPassword){
        this.setUsername(myLogin);
        this.setPassword(myPassword);
        this.clickLogin();
    }
}
