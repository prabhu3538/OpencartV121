package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid -- login success -- test pass -- logout
 * Data is valid -- login failed -- test fail 
 * 
 * Data is invalid -- login success -- test fail -- logout
 * Data is invalid -- login fail -- test pass
 */

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class, groups="Datadriven")   //dataProviderClass=DataProviders.class this od not required if the data provider present in same class)
	public void verify_loginDDT(String email, String pwd, String exp) 											//getting dataprovider from diff class
	{
		logger.info("***Starting TC003_LoginDDT***");
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();      //login button
		
		//MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")) 
		{
			if(targetPage==true) 
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	} 
		catch(Exception e) {
		Assert.fail("An exception occured: " + e.getMessage());;
	}
		logger.info("***Finished TC003_LoginDDT***");

	}
}

