package pelican.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WilliamSonomaProductDetailPage extends WillianSonomaHomePage{
	
	@FindBy(css = ".btn.btn_addtobasket.btn_addtobasket_add")
	private WebElement addToCartButton;
	
	@FindBy(css = "#anchor-btn-checkout")
	private WebElement checkoutButtonInPopUp;
	
	public WilliamSonomaProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Method to click on Add to Cart Button
	 */
	public void clickOnAddToCartButton() {
		checkoutButtonInPopUp.click();
		System.out.println("Clicked on Add to Cart Button");
	}
	
	/**
	 * Method to click on checkout Button On pop up	 
	 */
	public WilliamSonomaShoppingCartPage clickOnCheckoutButtonOnPopUp() {
		checkoutButtonInPopUp.click();
		System.out.println("Clicked on checkout in pop up window");
		return getPage(WilliamSonomaShoppingCartPage.class);
	}

}
