package Utilities;

import org.openqa.selenium.By;

public class locator {
	
	public By userName = By.id("user-name");
	public By password = By.id("password");
	public By loginBtn = By.id("login-button");
	public By loginLogo = By.className("login_logo");
	public By dashboard_title = By.xpath("/html/body/div/div/div/div[1]/div[2]/span");
	public By item = By.className("inventory_item_img");
	public By BackProducts = By.id("back-to-products");
	public By inventoryListName = By.className("inventory_item_name");
	public By addCartbutton = By.id("add-to-cart-sauce-labs-backpack");
	public By removeCartbutton = By.id("remove-sauce-labs-backpack");
}
