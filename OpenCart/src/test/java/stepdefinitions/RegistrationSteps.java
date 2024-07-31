package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class RegistrationSteps {
	 WebDriver driver;
     HomePage hp;
     LoginPage lp;
     AccountRegistrationPage regpage;
	
	@Given("the user navigates to register Account page")
	public void the_user_navigates_to_register_account_page() throws InterruptedException {
		Thread.sleep(1000);
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickRegister();
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		regpage=new AccountRegistrationPage(BaseClass.getDriver());
		regpage.setFirstname(dataMap.get("firstName"));
		regpage.setLastname(dataMap.get("lastName"));
		regpage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
		regpage.setTelephone(dataMap.get("telephone"));
		regpage.setPassword(dataMap.get("password"));
		regpage.setConfirmPassword(dataMap.get("password"));
		
	}

	@When("the user selects privacy policy")
	public void the_user_selects_privacy_policy() {
	   regpage.setPrivacypolicy();
	}

	@When("the user clicks on continue button")
	public void the_user_clicks_on_continue_button() {
	   regpage.ClickContinue();
	}

	@Then("the useer account should get createed sucessfully")
	public void the_useer_account_should_get_createed_sucessfully() {
		String confmsg= regpage.getConfirmationmsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	    }



}
