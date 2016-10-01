package pelican.user;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.Util;

public class WillianSonomaHomePage {
	@FindBy(xpath = ".//*[@id='imagerollover-736600681']/map/area[3]")
	private WebElement leCreusetCookWear;
		
	@FindBy(css = ".topnav-cookware")
	private WebElement topNavCookWare;
	
	@FindBy(xpath = ".//*[@id='topnav-container']/ul/li[1]/div/div[1]/ul[1]/li[10]/a")
	private WebElement topNavCookWareKettels;
	
	private WebDriver driver;
	private static final String WilliamSonomaHomaPageUrl = "http://www.williams-sonoma.com";
	
	public WillianSonomaHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Method to navigate to William Sonoma Home Page
	 */
	public void navigateWilliamSonomaHomePage() {
		Util.printInfo("Navigate to '" + WilliamSonomaHomaPageUrl + "'");
		getDriver().get(WilliamSonomaHomaPageUrl);
	}
	
	/**
	 * method to click on Kettels under Cookware
	 * @param index
	 */
	public WilliamSonomaCookWareKettelPage clickOnKettle() {
		topNavCookWareKettels.click();
		System.out.println("Link of Kettle has been clicked");
		return getPage(WilliamSonomaCookWareKettelPage.class);
	}
	
	/**
	 * 
	 * @param klass
	 * @return page
	 */
    protected <T extends WillianSonomaHomePage> T getPage(Class<T> klass) {
    	T page;
    	try {
	    	// Instantiate page
	    	try {
		        Constructor<T> constructor = klass.getConstructor(WebDriver.class);
		        page = constructor.newInstance(driver);
	        } catch (NoSuchMethodException e) {
	            page = klass.newInstance();
	        }
	    	page.setDriver(driver);
	    	PageFactory.initElements(driver, page);
	    	return page;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
	}
}
