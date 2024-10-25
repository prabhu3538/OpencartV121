package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		try {
		logger.info("****TC001_AccountRegistrationTest****");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("****Clicked on MyAccount****");
		
		hp.clickRegister();	
		logger.info("****Clicked On Register****");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("****Providing customer details****");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com"); //randomly generated email
		regpage.setTelephone(randomeNumber());
		
		String password = randomeAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("****Validating Expected message****");
		
		String confmsg = regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} 
		catch(Exception e)
		{
			logger.error("Test failed...");
			logger.debug("Debug logs...");      //If TC failed it will execute 
			Assert.fail();
		}
		logger.info("****Finished TC001_AccountRegistrationTest****");

	}
	 	
}
