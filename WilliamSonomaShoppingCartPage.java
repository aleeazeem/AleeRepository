package pelican.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WilliamSonomaShoppingCartPage extends WillianSonomaHomePage {
	
	@FindBy(css = ".moveToSFL.save-for-later-link")
	private WebElement saveForLaterButton;
	
	@FindBy(css = "#cart-count")
	private WebElement quantityInCart;
	
	@FindBy(css = ".save-for-later-message>a")
	private WebElement savedItems;
			
	public WilliamSonomaShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Method to click on save it for later
	 */
	public void clickOnSaveItForLater() {
		saveForLaterButton.click();
		System.out.println("Item is saved for later");
	}
	
	/**
	 * Method to check Link of Save For Later is Presenet
	 */
	public boolean isSaveForLetterLinkPresent() {
		boolean isSaveForLetterLinkPresent = false;
		try {
			isSaveForLetterLinkPresent = saveForLaterButton.isDisplayed();
			System.out.println("*Save for Later* Link is present");
		} catch (org.openqa.selenium.NoSuchElementException ex) {
			System.out.println("*Save for Later* Link is not present");
		}
		return isSaveForLetterLinkPresent;
	}
	
	/**
	 * Method to get text of save items
	 */
	public String getTextofSaveItems() {
		return savedItems.getText();
	}
	
	/**
	 * Method to get quantity in cart
	 */
	public String getQuantityInCart() {
		return quantityInCart.getText();
	}
}
