package week3.day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnFrame {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

		// Browser Context
		BrowserContext context = browser.newContext();

		// Open page and load URL
		Page page = context.newPage();
		page.setDefaultTimeout(5000);
		page.navigate("https://www.leafground.com/frame.xhtml");
		
		// Find the frame using its locator
		FrameLocator parentFrame = page.frameLocator("(//iframe)[3]");
		
		// Go to the child frame
		FrameLocator childFrame = parentFrame.frameLocator("#frame2");
		
		// Click 
		childFrame.locator("#Click").click();
		
		page.frameLocator("(//iframe)[1]").locator("#Click").click();

		

	}

}
