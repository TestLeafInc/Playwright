package week2.day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserActions {
	
	
	// Interface --> Concrete Class (Impl)
	
	public static void main(String[] args) {
		
		// Initialize Playwright
		Playwright pw = Playwright.create();
		
		// Launch the browser (CDT API --> headless)
		/*Browser browser = pw.chromium().launch(
					new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)
				);*/
		
		/*Browser browser = pw.firefox().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
			);
		*/
		
		/*
		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false)
			);
		*/
		
		Browser browser = pw.webkit().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
			);
		
		// Open a new page
		Page page = browser.newPage();
		
		// load the url
		page.navigate("http://leaftaps.com/opentaps");
		
		// close the browser
		//page.close();
		
		//browser.close();
		
	}

}
