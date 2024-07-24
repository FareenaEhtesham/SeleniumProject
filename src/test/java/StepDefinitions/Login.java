package StepDefinitions;


import org.openqa.selenium.WebDriver;

import Utilities.Method;
import Utilities.driverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login{
	
	static driverClass driver;
	static WebDriver driver1 = driverClass.getDriver("chrome");
	Method methods = new Method(driver1);
	
		@Given("User is on the login page")
		public void user_is_on_the_login_page() throws Exception {
		  methods.getSite();
		}

		@When("click on username field and add name")
		public void click_on_username_field_and_add_name() throws Exception {
			methods.Login();
		}

		@Then("click on Password field and add password")
		public void click_on_password_field_and_add_password() {
		   
		}

		@Then("click on SignIn button")
		public void click_on_sign_in_button() {
		  
		}

		@Then("user successfully redirects to the dashboard page")
		public void user_successfully_redirects_to_the_dashboard_page() {
		   
		}	
}
