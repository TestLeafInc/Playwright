package week3.day2;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;

public class FileUpload {
	
	public static void main(String[] args) throws InterruptedException {
		

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();
		page.navigate("https://www.leafground.com/file.xhtml");
		
		page.locator("(//input[@type='file'])[2]")
		.setInputFiles(Paths.get("pom.xml"));
		
		Locator locator = page.locator(".ui-messages-error");
		locator.highlight();
		String textContent = page.locator(".ui-messages-error").textContent();
	
		System.out.println(textContent);
		
		
		/*
		 * 1) Dialog
		 * 2) Frame
		 * 3) Window 
		 * 4) Mouse Actions - Drag and Drag, Hover, Mouse
		 * 5) Keyboard Actions - Press, Down
		 * 6) Shadow DOM - Pierce, Xpath
		 * 7) File Upload and Download
		 * 8) textContent, focus, BoundingBox - x, y, width, height
		 * 9) highlight 
		 * 10) slowMotion
		 * 
		 * 
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
