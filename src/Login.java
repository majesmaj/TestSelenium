import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\makro\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // credentials
        String url = "http://www.automationpractice.com/";
        String myLogin = "DanielEMiller@rhyta.com";
        String myPassword = "kuong0io6Qu";

        // get the site and proceed to the SignIn page
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();

        // using our credential to login
        driver.findElement(By.id("email")).sendKeys(myLogin);
        driver.findElement(By.id("passwd")).sendKeys(myPassword);
        driver.findElement(By.name("SubmitLogin")).click();

        // check if logged on proper acc
        String accName = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

        if (accName.equals("Daniel Miller"))
        {
            System.out.println("You are logged on " + accName +" account");
        }
        else
        {
            System.out.println("You are on wrong account");
        }

        // wait time then closing the browser
        Thread.sleep(5000);
        driver.quit();

    }
}
