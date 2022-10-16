package week4.day1;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class GetCDP_Details {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		try {
		
			Browser browser = pw.chromium().launch(
					new BrowserType.LaunchOptions()
					.setArgs(Arrays.asList("--remote-debugging-port=9222"))
					.setChannel("chrome")
					.setHeadless(false));
	
			// Browser Context
			BrowserContext context = browser.newContext();
	
			Page page = context.newPage();
			page.navigate("http://leaftaps.com/opentaps/control/main");
	
			// Find the username and enter the value
			page.locator("id=username").type("democsr");
	
			// Find the password and enter the value
			page.locator("#password").type("crmsfa");
	
			// Find the login and click
			page.locator(".decorativeSubmit").click();
			
			Page newPage = context.newPage();
			pw.close();
		} catch(Exception e) {
			//pw.close();
		}
		
	}

}
