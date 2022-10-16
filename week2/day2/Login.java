package week2.day2;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Login {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
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
		
		// Store the information as json (storage)
		context.storageState
			(new BrowserContext.StorageStateOptions()
					.setPath(Paths.get("login_leaftaps_democsr.json")));
		
		
	}

}
