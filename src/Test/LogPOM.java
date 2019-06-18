package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.FrontPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogPOM{
    WebDriver driver;
    HomePage hp;
    LoginPage lp;
    FrontPage fp;

    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\makro\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterTest
    public void shutDown()
    {
        driver.quit();
    }

    @Test
    public void logInTest() throws InterruptedException
    {
        fp = new FrontPage(driver);
        hp = new HomePage(driver);
        lp = new LoginPage(driver);

        fp.clickSignIn();

        lp.accountLogin("DanielEMiller@rhyta.com","kuong0io6Qu");

        Thread.sleep(5000);

        Assert.assertEquals(hp.getHomePageUsername(), "Daniel Miller");
    }

    @Test
    public void logOutLogInTest()
    {
        hp = new HomePage(driver);
        lp = new LoginPage(driver);

        lp.clickSignOut();
        lp.setUsername("DanielEMiller@rhyta.com");
        lp.setPassword("kuong0io6Qu");
        lp.clickLogin();

        Assert.assertEquals(hp.getHomePageUsername(), "Daniel Miller");
    }
}
