package Utilities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


public class Method extends locator{
	
	
	driverClass obj;
	public WebDriver driver ;
	
	public Method(WebDriver driver1){
	        this.driver = driver1;
	    }
	    
	public String getDataFromConfigFile(String value) throws Exception {
		
		try {
			FileReader file=new FileReader("C:\\Users\\Fareena\\eclipse-workspace\\SeleniumDemoProject\\config.properties"); 
	        Properties props=new Properties(); 
	        props.load(file);
	       String valueConfig = props.getProperty(value);
	       return valueConfig;
		}
		
		catch(Exception e) {
			throw(e);
		}
		 
	}
	
	
public void enterText(By elementlocator, String dataValue) {
		
		try {
			WebElement element =driver.findElement(elementlocator);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(elementlocator));
			element.sendKeys(dataValue);
		}
		catch(Exception e) {
			throw(e);
		}
			
	}
	
	public void clickButton(By elementlocator) {
		
		try {
			WebElement element =driver.findElement(elementlocator);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(elementlocator));
			element.click();
		}
		catch(Exception e) {
			throw(e);
		}
	}
	
	public void getSite() throws Exception {
		
		driver.get(getDataFromConfigFile("demoSite"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(loginLogo));
		
	}
	
	public void assertDashboardPage() {
		try {
			String text_title = driver.findElement(dashboard_title).getText();
			System.out.println("Text" + text_title);
			assertEquals("Products",text_title );
			
		}
		catch(Exception e){
			throw(e);
		}
		
		
	}
	
    public void Login() throws Exception{
    	
    	enterText(userName, getDataFromConfigFile("user_name"));
    	enterText(password, getDataFromConfigFile("password"));
    	clickButton(loginBtn);
    	
    	takeSnapShot(driver, "C:\\Users\\Fareena\\eclipse-workspace\\SeleniumDemoProject\\Screenshots\\test.png");
    	
    }
    
    
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
    
    	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    	File DestFile=new File(fileWithPath);
    	FileUtils.copyFile(SrcFile, DestFile);
    	}
    
    public void ProductCount() {
    	List <WebElement>productList = driver.findElements(inventoryListName);
    	int productListCount = productList.size();
    	System.out.println("total no of products uploaded" +productListCount );
    	
    	for(int i=0; i<productListCount; i++) {
    		System.out.println(productList.get(i).getText());
    	}
    }
    
    public void ClickProduct() {
    	
    	clickButton(item);
    	try {
			String title = driver.findElement(BackProducts).getText();
			System.out.println("Text" + title);
			assertEquals("Back to products",title );
			
		}
		catch(Exception e){
			throw(e);
		}
    }
    
    public void AddToCart() {
    	clickButton(BackProducts);
    }

    public void assertButtonClickable() {
    	
    	String beforeClick = driver.findElement(addCartbutton).getText();
    	System.out.println("Before click value was" + beforeClick);
    	clickButton(addCartbutton);
    	String afterClick = driver.findElement(removeCartbutton).getText();
    	System.out.println("After click value is" + afterClick);
    	
    	try {
    		assert beforeClick!= afterClick;
    		System.out.println(beforeClick + "After click" + afterClick);
    	}
    	
    	catch(Exception e) {
    		throw(e);
    	}
    }

}
