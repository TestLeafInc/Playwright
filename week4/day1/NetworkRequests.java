package week4.day1;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import jdk.nashorn.internal.codegen.types.Type;

public class NetworkRequests {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions()
				.setChannel("chrome").setHeadless(false));

		// Browser Context
		BrowserContext context = browser.newContext();

		// Open page and load URL
		Page page = context.newPage();
		
		// Listener -> onRequest
		page.onRequest(handler -> {
			String method = handler.method();
			if(handler.method().equalsIgnoreCase("post")) {
				System.out.println(method);
				String postData = handler.postData();
				System.out.println(postData);
			}
		});
		
		page.onResponse(handler -> {
			System.out.println(handler.status());
		});


		// Load the page with URL
		page.navigate("https://login.salesforce.com/");

		page.type("#username", "ramkumar.ramaiah@testleaf.com");
		page.type("#password", "Password#123");
		page.click("#Login");
		page.click(".slds-icon-waffle");
		page.click("(//p[text()='Service'])[1]");
		page.click("(//span[text()='Accounts'])[1]");
		page.click("(//div[@title='New'])[1]");
		page.type("(//label[text()='Account Name']/following::input)[1]","Babu");
		page.click("(//button[text()='Save'])[1]");
		

	}

}
