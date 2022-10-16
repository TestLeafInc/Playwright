package week3.day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;

public class Flipkart {
	
	public static void main(String[] args) {
		

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();
		page.navigate("https://jqueryui.com/droppable/");
		FrameLocator frame = page.frameLocator(".demo-frame");
		
		Locator draggable = frame.locator("#draggable");
		Locator droppable = frame.locator("#droppable");
		
		draggable.dragTo(droppable);
		
		// find the position
		BoundingBox bound = draggable.boundingBox();
		System.out.println(bound.x);
		System.out.println(bound.y);
		
		System.out.println(droppable.textContent());
		
		
	}

}
