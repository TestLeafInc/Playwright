package week5.day1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseClass {
	
	public Playwright pw;
	public Browser browser;
	public Page page;


	@BeforeMethod
	public void setup() {

		pw = Playwright.create();

		browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		page = browser.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");

		// Find the username and enter the value
		page.locator("id=username").type("demosalesmanager");

		// Find the password and enter the value
		page.locator("#password").type("crmsfa");

		// Find the login and click
		page.locator(".decorativeSubmit").click();

		// Click on the CRM/SFA
		page.locator("text=CRM/SFA").click();

		// Click Leads Tab
		page.locator("a:has-text('Leads')").click();
	}
	
	@AfterMethod
	public void tearDown() {
		pw.close();
	}

}
