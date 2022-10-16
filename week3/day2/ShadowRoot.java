package week3.day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;

public class ShadowRoot {
	
	public static void main(String[] args) throws InterruptedException {
		

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();
		page.navigate("https://dev138341.service-now.com/now/appenginestudio/home");
		
		page.locator("#user_name").type("admin");
		page.locator("#user_password").type("fWDBjxa83@t$FiIA");
		page.click("#sysverb_login");
		
		page.locator("text=Add a table").click();
		
		page.locator(".sn-aes-search-input").type("Babu");

		page.locator("#my-appsNavItem").click();
		
		page.locator("text=Create app").click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
