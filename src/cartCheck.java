import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class cartCheck {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\makro\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);

        // initializing
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "http://www.automationpractice.com/";
        driver.get(url);

        //using searchbar
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.name("submit_search")).submit();

        //checking if elements are displayed
        if (driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul")).isDisplayed())
        {
            System.out.println("Products are displayed");

            //adding element to our cart
            WebElement element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]"));
            action.moveToElement(element).build().perform();
            driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();


            //checking if there is one product added to the cart
            String cartValue = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")).getText();
            if (cartValue.equals("1"))
            {
                System.out.println("Succesfully added product to your cart");
            }
            else
            {
                System.out.println("There is nothing in the cart");
            }

        }
        else
        {
            System.out.println("Products are not displayed");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
