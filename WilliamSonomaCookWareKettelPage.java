package pelican.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WilliamSonomaCookWareKettelPage extends WillianSonomaHomePage{
	
	@FindBy(xpath = ".//ul[@class='shop-list product-list']/li[1]")
	private WebElement firstImageWithLink;
	  

	public WilliamSonomaCookWareKettelPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * method to return datail page of selected item which is selected randomly
	 * @param index
	 * @return detail page of product
	 */
	public WilliamSonomaProductDetailPage selectProductRandomly(int index) {
		String selector = ".//ul[@class='shop-list product-list']/li[" + index + "]";
		getDriver().findElement(By.xpath(selector));
		firstImageWithLink.click();
		System.out.println("Link of Kettle has been clicked");
		return getPage(WilliamSonomaProductDetailPage.class);
	}
}