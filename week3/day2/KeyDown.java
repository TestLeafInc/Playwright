package week3.day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyDown {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				//.setSlowMo(2000)
				.setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();
		page.navigate("https://jqueryui.com/autocomplete/");
		FrameLocator frame = page.frameLocator(".demo-frame");
		Locator tag = frame.locator("#tags");
		tag.type("A");
		page.keyboard().down("ArrowDown");
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
		
		String attribute = tag.getAttribute("value");
		System.out.println(attribute);
		
		
	}

}
