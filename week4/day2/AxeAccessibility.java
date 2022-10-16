package week4.day2;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.deque.html.axecore.playwright.AxeBuilder;
import com.deque.html.axecore.results.AxeResults;
import com.deque.html.axecore.results.Rule;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AxeAccessibility {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		/*BrowserContext context = pw.chromium()
				.launchPersistentContext(Paths.get("~/Library/Application Support/Google/Chrome"),
					new BrowserType.LaunchPersistentContextOptions()
					//.setArgs(Arrays.asList("--disable-notifications"))
					.setChannel("chrome").setHeadless(false)
				);
		
		
		// Open page and load URL
		Page page = context.pages().get(0); */
		
		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();
		
		// Load the page with URL
		page.navigate("https://www.bookmyshow.com");
		
		AxeBuilder axeBuilder = new AxeBuilder(page);
		List<Rule> violations = axeBuilder.analyze().getViolations();
		System.out.println(violations);

		
	}

}
