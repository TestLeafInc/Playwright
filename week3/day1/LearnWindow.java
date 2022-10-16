package week3.day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnWindow {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

		// Browser Context
		BrowserContext context = browser.newContext();

		// Open page and load URL
		Page page = context.newPage();
		page.setDefaultTimeout(5000);
		page.navigate("https://www.leafground.com/window.xhtml");
		
		// Click on the Open button
		page.locator("//h5[text()='Click and Confirm new Window Opens']/following::span[1]").click();
		
		// Wait for the page to load or element to exist !
		Page newPage = context.waitForPage( () -> {
			page.locator("text=Resolution Center").isVisible();
		});
		
		// start interacting with new page
		newPage.locator("#email").type("hello@testleaf.com");
		
		//newPage.close();
		
		// Click on the Open button
		page.locator("//h5[text()='Click and Confirm new Window Opens']/following::span[1]").click();
		
		Page thirdPage = context.waitForPage( () -> {
			page.locator("text=Resolution Center").isVisible();
		});
		
		System.out.println(newPage.title());

	}

}
