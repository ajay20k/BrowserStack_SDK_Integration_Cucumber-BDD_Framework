package utils;

import baseFiles.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class WebUtil extends CommonUtil {

    public static WebDriver driver;

    public static WebDriver initWebDriver() throws InterruptedException, IOException {
                switch (ConfigUtil.getPropertyValue("local_browserName")) {
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    default:
                        System.out.println("Please enter valid browser name");
                }
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit Wait
                driver.manage().window().maximize();
        return driver;
    }

    public static WebDriverWait initWebWait(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit Wait
        return wait;
    }

    public static void quitDriver() {
        driver.quit();
    }
}
