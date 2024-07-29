package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Utilities.Method;
import Utilities.driverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MDashboard {
	
	static WebDriver driver1 = driverClass.getDriver("chrome");
	static driverClass driver;
	Method methods = new Method(driver1);
	
	@Given("user is on dashboard page")
	public void user_is_on_dashboard_page() throws Exception {
		 methods.getSite();
		 methods.Login();
		 methods.assertDashboardPage();
	}
	
	@Then("count total no of products available")
	public void count_total_no_of_products_available() {
	 methods.ProductCount();
	}

	@When("click on any product detail view should be open")
	public void click_on_any_product_detail_view_should_be_open() {
	   methods.ClickProduct();
	}

	@Then("verify detail view of the product")
	public void verify_detail_view_of_the_product() {
	  
	}

	@When("click on Add to Cart of the product")
	public void click_on_add_to_cart_of_the_product() throws InterruptedException {
		 methods.AddToCart();
	}
	
	@Then("verify button is clickable")
	public void verify_button_is_clickable() {
		methods.assertButtonClickable();
	}

	@Then("verify product has been successfully added")
	public void verify_product_has_been_successfully_added() {
	   
	}

}
