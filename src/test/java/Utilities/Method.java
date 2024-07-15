package Utilities;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Method extends locator{
	
	driverClass obj;
	public WebDriver driver;
	
	public Method(WebDriver driver){
	        this.driver = driver;
	    }
	    
	public void getSite() {
		
		driver.get("https://www.saucedemo.com/");
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(loginLogo));
		
	}
	
    public void Login(String user_name, String pass) throws Exception{
    
    	driver.findElement(userName).sendKeys(user_name);
    	driver.findElement(password).sendKeys(pass);
    	driver.findElement(loginBtn).click();
    	
    	takeSnapShot(driver, "C:\\Users\\Fareena\\eclipse-workspace\\SeleniumDemoProject\\Screenshots\\test.png");
    	
    }
    
    
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
    
    	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    	File DestFile=new File(fileWithPath);
    	FileUtils.copyFile(SrcFile, DestFile);
    	}

}
