package week3.day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;

public class DragAndDrop {
	
	public static void main(String[] args) {
		

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setSlowMo(2000)
				.setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();
		/*
		page.navigate("https://flipkart.com");
		page.click("//button[text()='✕']");
		page.locator("//div[text()='Electronics']").hover();
		page.locator("//a[text()='Gaming']").hover(); */
		
		page.navigate("https://www.geeksforgeeks.org/");
		//page.click("//span[text()='×']");
		page.hover("//span[text()='Tutorials']");
		page.hover("//span[text()='Data Structures']");
		page.click("(//a[text()='Arrays'])[1]");


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
