package Stepdef.Popbitch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Elements.Finish_Notice_elements;
import Elements.Popbitch_First_Use_Notice_Elements;
import Elements.Wallet_Elements;
import Elements.Register_Page_Elements1;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class POPSMO17_transaction_from_finish_notice {
	WebDriver driver;
	
	@Given("I am a user of Axate and I am on the registration page through popbitch FUN {string}")
	@Test(priority=99)
	@Parameters("browser")
	public void i_am_a_user_of_Axate_and_I_am_on_the_registration_page_through_popbitch_FUN(String browser) throws InterruptedException {

			//firefox
			if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","C:/Users/Administrator/Desktop/geckodriver.exe");		
				driver = new FirefoxDriver();
				driver.get("http://popbitch.agate.one/2017/10/the-harder-they-fall-2/");
				Popbitch_First_Use_Notice_Elements popbitch_first_use_elements= new Popbitch_First_Use_Notice_Elements(driver);
				popbitch_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
				String reg_Page_url= driver.getCurrentUrl();
				if(reg_Page_url.contains("sign"))
				{
					System.out.println("Clicking on create wallet opened registration page");
				}			
			}	
			//safari
				else if (browser.equalsIgnoreCase("safari")) { 
					driver= new SafariDriver();
					driver.manage().window().maximize();
					try {
						driver.get("http://popbitch.agate.one/2017/10/the-harder-they-fall-2/");					
					}
					catch(Exception e)
					{
						System.out.println("Couldnt open popbitch staging");
					}
					Popbitch_First_Use_Notice_Elements popbitch_first_use_elements= new Popbitch_First_Use_Notice_Elements(driver);
					popbitch_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
					String reg_Page_url= driver.getCurrentUrl();
					if(reg_Page_url.contains("sign"))
					{
						System.out.println("Clicking on create wallet opened registration page");
					}
			} 
			//chrome
				else if (browser.equalsIgnoreCase("chrome")) { 
					System.setProperty("webdriver.chrome.driver","/Users/jay/eclipse-workspace/chromedriver");				
					driver= new ChromeDriver();				
					driver.get("https://popbitch.com/2019/11/royal-blush/");
					Thread.sleep(4000);
					Popbitch_First_Use_Notice_Elements popbitch_first_use_elements= new Popbitch_First_Use_Notice_Elements(driver);
					popbitch_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
					String reg_Page_url= driver.getCurrentUrl();
					if(reg_Page_url.contains("https://account.agate.io/my-agate/sign-up?"))
					{
						System.out.println("Clicking on create wallet opened registration page");
					}
			} 
			//edge
				else if (browser.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver","/Users/jay/eclipse-workspace/chromedriver"); 
				driver = new EdgeDriver();
			}	
		}

	@When("I register successfully on popbitch with one pound")
	@Test(priority=100)
	public void i_register_successfully_on_popbitch_with_one_pound() throws InterruptedException {
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(driver);
		Reg_page_elements.Registration_Step1();
		Reg_page_elements.voucher_process();
		Thread.sleep(2000);
		Reg_page_elements.click_continue_on_reg_page2();
		Wallet_Elements w1 = new Wallet_Elements(driver);
		w1.Click_On_popbitch_staging_agate_poster();
		String actual_current_balance=w1.current_balance();
		String expected_current_balance="10.00";
		Assert.assertEquals(actual_current_balance, expected_current_balance);
		Finish_Notice_elements finish_notice = new Finish_Notice_elements(driver);
		Boolean Actual_result = finish_notice.Verify_finish_notice_appears();
		Boolean Expected_result= true;
		Assert.assertEquals(Actual_result, Expected_result);
	}

	@When("opt just charge me on the finish notice and click ok")
	@Test(priority=101)
	public void opt_just_charge_me_on_the_finish_notice_and_click_ok() throws InterruptedException {
		Finish_Notice_elements finish = new Finish_Notice_elements(driver);
		finish.popbitch_click_ok_on_finish_notice();
	}
	
	@Then("twentyfivep is displayed on the green tab")
	@Test(priority=102)
	public void twentyfivep_is_displayed_on_the_green_tab() {
		Wallet_Elements w1 = new Wallet_Elements(driver);
		String actual_price= w1.green_tab_price();
		String expected_price= "25";
		Assert.assertEquals(actual_price, expected_price);
				
	}

	@Then("wallet balance is detucted by twentyfivep")
	@Test(priority=103)
	public void wallet_balance_is_detucted_by_twentyfivep() throws InterruptedException {
		Wallet_Elements w1 = new Wallet_Elements(driver);
		w1.Click_On_popbitch_staging_agate_poster();
		String actual_current_balance=w1.current_balance();
		String expected_current_balance="9.75";
		Assert.assertEquals(actual_current_balance, expected_current_balance);
	}

	@Then("free point is detucted by twentyfivep")
	@Test(priority=104)
	public void free_point_is_detucted_by_twentyfivep() throws InterruptedException {
		Wallet_Elements w1 = new Wallet_Elements(driver);
		w1.Click_On_popbitch_staging_agate_poster();
		String actual_free_point=w1.Free_point();
		String expected_free_point="25";
		Assert.assertEquals(actual_free_point, expected_free_point);
	}

//doesnt work on automation - fix later	
/* 
	@Then("full article is displayed to the user")
	@Test(priority=105)
	public void full_article_is_displayed_to_the_user() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement paragraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/main/article/div/div[3]/p[9]")));				
	   Boolean displayed = driver.findElement(By.xpath("/html/body/div[2]/div/div/main/article/div/div[3]/p[9]")).isDisplayed();
	   
	   Boolean Expected_displayed = true;
	   Assert.assertEquals(displayed, Expected_displayed);
	   System.out.print("full article displayed");
	   String Para= paragraph.getText();
	   Assert.assertTrue(Para.contains("foo"));	
	   System.out.print(Para);
	   
	   
	}

*/


}
