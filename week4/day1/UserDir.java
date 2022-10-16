package week4.day1;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import jdk.nashorn.internal.codegen.types.Type;

public class UserDir {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		BrowserContext context = pw.chromium()
				.launchPersistentContext(Paths.get("~/Library/Application Support/Google/Chrome"),
						new BrowserType.LaunchPersistentContextOptions()
						//.setArgs(Arrays.asList("--start-maximized"))
						//.setArgs(Arrays.asList("--incognito"))

						.setChannel("chrome")
						.setHeadless(false));
		
		// Open page and load URL
		Page page = context.pages().get(0);
		
		// Listen to the console messages
		page.onConsoleMessage(handler -> {
			System.out.println(page.url());
			System.out.println(handler.type());
			System.out.println(handler.text());
		});

		// Load the page with URL
		page.navigate("https://www.bookmyshow.com");

		System.out.println(page.title());
	}

}
