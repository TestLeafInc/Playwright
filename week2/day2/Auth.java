package week2.day2;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Auth {


	public static void main(String[] args) {
		
		
		// Initialize Playwright
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)
				);
		
		// Browser Context
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions()
				.setHttpCredentials("admin","admin"));

		// Open a new page
		Page page = context.newPage();
		
		// load the url
		page.navigate("https://the-internet.herokuapp.com/basic_auth");
		
		
		
		//pw.close();
	}

}
