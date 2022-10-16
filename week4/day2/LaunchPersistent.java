package week4.day2;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchPersistent {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		/*Browser browser = pw.chromium().launch
				(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));*/
		
		BrowserContext context = pw.chromium()
				.launchPersistentContext(Paths.get("~/Library/Application Support/Google/Chrome"),
					new BrowserType.LaunchPersistentContextOptions()
					.setChannel("chrome").setHeadless(false)
				);
		
		// Open page and load URL
		Page page = context.pages().get(0);
		
		// Load the page with URL
		page.navigate("https://www.bookmyshow.com");

		System.out.println(page.title());
	}

}
