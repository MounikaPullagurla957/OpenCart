package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtlastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txttelephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmpassword;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdpolicy;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement btncontinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastname(String lname) {
		txtlastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
 public void setTelephone(String number)
 {
	 
	 txttelephone.sendKeys(number);
 }
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwd) {
		txtConfirmpassword.sendKeys(pwd);
	}

	public void setPrivacypolicy() {
		chkdpolicy.click();
	}

	public void ClickContinue() {
	
		btncontinue.click();
	}
	public String getConfirmationmsg() {
		try {

			return(msgconfirmation.getText());

		}catch(Exception e)
		{
			return(e.getMessage());
		}

	}
}

