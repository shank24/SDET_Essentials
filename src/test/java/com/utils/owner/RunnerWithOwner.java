package com.utils.owner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RunnerWithOwner {

    //Owner Example
    public static void main(String[] args) throws InterruptedException {
        FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
        System.out.println(config.browser());

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        synchronized(driver){
            driver.wait(5000);
        }

        driver.manage().timeouts().implicitlyWait(config.timeout(), config.value());
        System.out.println(config.timeout());

        if(config.takeScreenshot()){
            //Write Some Code here
        }
        config.tools().forEach(System.out::println);
        driver.close();
    }
}
