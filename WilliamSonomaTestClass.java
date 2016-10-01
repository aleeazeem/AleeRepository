package pelican.user;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import pelican.init.bicPelicanWebService;

public class WilliamSonomaTestClass extends bicPelicanWebService {
	static WebDriver driver;
	private static WillianSonomaHomePage williamSonomaHomePage ;
	
	/**
	 * Data setup - 
	 */
	@BeforeClass
	public static void classSetup () {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		williamSonomaHomePage = new WillianSonomaHomePage(driver);
		williamSonomaHomePage.navigateWilliamSonomaHomePage();	
		williamSonomaHomePage.clickOnKettle();
		
	}
	
	@AfterClass
	public static void closeDriver() {
		driver.close();
	}
	

	@Test
	public void testItemIsSavedForLaterPurchase(){
		WilliamSonomaCookWareKettelPage williamSonomaCookWareKettelPage = williamSonomaHomePage.clickOnKettle();
		Random index = new Random();
		int randomKettel = index.nextInt(4) + 0;
		WilliamSonomaProductDetailPage williamSonomaProductDetailPage = williamSonomaCookWareKettelPage.
			selectProductRandomly(randomKettel);
		williamSonomaProductDetailPage.clickOnAddToCartButton();
		WilliamSonomaShoppingCartPage williamSonomaShoppingCartPage = williamSonomaProductDetailPage.
			clickOnCheckoutButtonOnPopUp();
		Assert.assertTrue("*Save for Later* is not present on Page ", williamSonomaShoppingCartPage.
			isSaveForLetterLinkPresent());
		williamSonomaShoppingCartPage.clickOnSaveItForLater();
		int numberOfItems = Integer.valueOf((williamSonomaShoppingCartPage.getTextofSaveItems()).substring(0, 1));
		
		if (numberOfItems == 0) {
			Assert.fail("None of the Item is saved");
		} else {
			System.out.println("Item is saved");
		}
		Assert.assertEquals("Item is not saved",williamSonomaShoppingCartPage, Integer.toString(numberOfItems)  + 
			"saved item");
	}
}
