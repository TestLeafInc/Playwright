package week3.day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyActions {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				//.setSlowMo(2000)
				.setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		page.locator("#username").type("democsr");
		page.keyboard().press("Tab");
		String attribute = page.locator("*:focus").getAttribute("id");
		System.out.println(attribute);
	}

}
