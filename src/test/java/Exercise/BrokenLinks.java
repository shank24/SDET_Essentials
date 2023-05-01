package Exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        List<String> urlList = new ArrayList<>();

        for (WebElement e:links) {
            String url = e.getAttribute("href");
            //checkBrokenLink(url);
            urlList.add(url);
        }
        urlList.parallelStream().forEach(e-> checkBrokenLink(e));
        driver.quit();

    }

    public static void checkBrokenLink(String urlLink){

        try{
            URL url = new URL(urlLink);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            if(connection.getResponseCode() >= 400){
                System.out.println(urlLink + " -----> " + connection.getResponseMessage() + " is a broken Link");
            }
            else{
                System.out.println(urlLink + " -----> " + connection.getResponseMessage());
            }

        } catch (Exception e) {

        }
    }
}
