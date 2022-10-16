package week4.day1;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import jdk.nashorn.internal.codegen.types.Type;

public class ConsoleMessage {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

		// Browser Context
		BrowserContext context = browser.newContext();

		// Open page and load URL
		Page page = context.newPage();

		// Listen to the console messages
		page.onConsoleMessage(handler -> {
			System.out.println(page.url());
			System.out.println(handler.type());
			System.out.println(handler.text());
		});


		// Load the page with URL
		page.navigate("https://www.redbus.in");


		page.navigate("https://www.geeksforgeeks.org/");


	}

}
