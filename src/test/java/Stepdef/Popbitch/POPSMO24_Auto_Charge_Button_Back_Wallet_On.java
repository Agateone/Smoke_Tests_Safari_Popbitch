package Stepdef.Popbitch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Elements.Authorise_charge_notice_popbitch;
import Elements.Finish_Notice_elements;
import Elements.Popbitch_First_Use_Notice_Elements;
import Elements.Wallet_Elements;
import Elements.Register_Page_Elements1;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class POPSMO24_Auto_Charge_Button_Back_Wallet_On {
	
		
		WebDriver driver;
		
		
		@Given("I am a user of Axate and I am on the registration page through popbitch FUN {string}")
		@Test(priority=148)
		@Parameters("browser")
		public void i_am_a_user_of_Axate_and_I_am_on_the_registration_page_through_popbitch_FUN(String browser) throws InterruptedException {
			//firefox
			if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","C:/Users/Administrator/Desktop/geckodriver.exe");		
				driver = new FirefoxDriver();
				driver.get("https://popbitch.com/2019/11/royal-blush/");
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
						driver.get("https://popbitch.com/2019/11/royal-blush/");					
					}
					catch(Exception e)
					{
						System.out.println("Couldnt open popbitch staging");
					}
					Popbitch_First_Use_Notice_Elements popbitch_first_use_elements= new Popbitch_First_Use_Notice_Elements(driver);
					popbitch_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
					String reg_Page_url= driver.getCurrentUrl();
					if(reg_Page_url.contains("https://account.agate.io/my-agate/sign-up?"))
					{
						System.out.println("Clicking on create wallet opened registration page");
					}
			} 
			//chrome
				else if (browser.equalsIgnoreCase("chrome")) { 
					System.setProperty("webdriver.chrome.driver","/Users/jay/eclipse-workspace/chromedriver");				
					driver= new ChromeDriver();				
					driver.get("https://popbitch.com/2019/11/royal-blush/");
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
		@Test(priority=149)
		public void i_register_successfully_on_popbitch_with_one_pound() throws InterruptedException {
			Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(driver);
			Reg_page_elements.Registration_Step1();
			Reg_page_elements.voucher_process();
			Reg_page_elements.click_continue_on_reg_page2();
		}
		
		@When("opt Ask me everytime on the finish notice and click ok")
		@Test(priority=150)
		public void opt_Ask_me_everytime_on_the_finish_notice_and_click_ok() throws InterruptedException, IOException {
			Finish_Notice_elements finish = new Finish_Notice_elements(driver);
			finish.popbitch_click_on_authy_and_ok();
		}

	
		@When("click ok on the authorise charge notice")
		@Test(priority=151)
		public void click_ok_on_the_authorise_charge_notice() throws IOException, InterruptedException {
		    Authorise_charge_notice_popbitch authy = new Authorise_charge_notice_popbitch(driver);
		    authy.authorise_charge_notice_click_continue();
		}
	

	
		
		
		@When("I open the flipped wallet")
		@Test(priority=152)
		public void i_open_the_flipped_wallet() throws InterruptedException {
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			Wallet_Elements w1 = new Wallet_Elements(driver);
			w1.Click_On_popbitch_staging_agate_poster();
			w1.flip_wallet();
		}
		
		@When("opt Just charge me on the autocharge button on the wallet")
		@Test(priority=153)
		public void opt_Just_charge_me_on_the_autocharge_button_on_the_wallet() throws InterruptedException {
			Wallet_Elements w1 = new Wallet_Elements(driver);
			w1.Click_authy_OFF();
			Thread.sleep(2000);
		}
		
		@When("navigate to another premium article on popbitch")
		@Test(priority=154)
		public void navigate_to_another_premium_article_on_popbitch() {
			driver.navigate().to("https://popbitch.com/2019/10/iv-art-of-the-dyl/");
			
		}

		@Then("wallet balance is detucted by twentyfivep")
		@Test(priority=155)
		public void wallet_balance_is_detucted_by_twentyfivep() throws InterruptedException {
			Wallet_Elements w1 = new Wallet_Elements(driver);
			w1.Click_On_popbitch_staging_agate_poster();
			String actual_current_balance=w1.current_balance();
			String expected_current_balance="9.50";
			Assert.assertEquals(actual_current_balance, expected_current_balance);
		}

}
