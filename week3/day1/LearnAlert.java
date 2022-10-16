package week3.day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnAlert {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

		// Browser Context
		BrowserContext context = browser.newContext();

		// Open page and load URL
		Page page = context.newPage();
		page.navigate("https://www.leafground.com/alert.xhtml");

		
		// Listener
		page.onceDialog( alert -> {
			String message = alert.message();
			System.out.println(message);
			alert.accept("Babu");
		});

		page.locator("(//span[text()='Show'])[1]").click();

		// Listener
		page.onceDialog( alert -> {
			String message = alert.message();
			System.out.println(message);
			alert.dismiss();
		});

		page.locator("(//span[text()='Show'])[2]").click();

	}

}
