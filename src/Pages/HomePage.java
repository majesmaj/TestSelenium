package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By homePageUsername = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //getting username
    public String getHomePageUsername(){
        return driver.findElement(homePageUsername).getText();
    }
}
