package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"regression","Master"})
	public void verify_account_registration() {
		logger.info("*********starting tc001_accountRegistrationTest***********");
		try {
			
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on myaccount link");
		hp.clickRegister();
		logger.info("Clicked on register Link");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("providing customer details");
		regpage.setFirstname(randomeString().toUpperCase());
		regpage.setLastname(randomeString().toUpperCase());
		regpage.setEmail(randomeString() + "@gmail.com");
		regpage.setTelephone(randomenumber());
		String password = randomeAlphanumeric();
		regpage.setPassword(password);

		regpage.setConfirmPassword(password);
		regpage.setPrivacypolicy();
		regpage.ClickContinue();
		logger.info("validating the expected message");
		String confmsg = regpage.getConfirmationmsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{

			logger.error("testfaild");
			logger.debug("debugmessages");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*********finished TC001_accountRegistrationTest***********");

	}
}
