package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {           //constructor
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")     //My Account page Heading
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")   //added in step6
	WebElement lnkLogout;
	
	public boolean isMyAccountPageExists() {
		try {
		return(msgHeading.isDisplayed());
	}
		catch(Exception e) {
			return false;
		}
	
	}
	public void clickLogout() {
	lnkLogout.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}