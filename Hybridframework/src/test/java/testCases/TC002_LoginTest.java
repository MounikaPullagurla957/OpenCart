package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"sanity","Master"})
	public void verify_login()
	{
		logger.info("*********starting tc002_LoginTest***********");
		try
		{
		//home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.ClickLogin();
		//myaccountoage
		MyAccountPage mac=new MyAccountPage(driver);
		boolean targetpage=mac.isMyAccountExists();
		Assert.assertTrue(targetpage);
		///Assert.assertEquals(targetpage, true,"Login failed");
		
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("*********Finished tc002_LoginTest***********");

}
}
