

package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class driverClass {
	
    static WebDriver driver;


    public static WebDriver getDriver(String browser){
        
        if (browser.equalsIgnoreCase("Chrome")){
        	WebDriverManager.chromedriver().clearDriverCache().setup();
        	driver = new ChromeDriver();
        }
        
        else if (browser.equalsIgnoreCase("Edge")) {
        	WebDriverManager.edgedriver().clearDriverCache().setup();
        	driver = new EdgeDriver();
        }
        else {
        	System.out.println("Incorrect browser");
        }
        driver.manage().window().maximize();
        return driver;
    }
}

