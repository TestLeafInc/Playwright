package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

import jdk.nashorn.internal.codegen.types.Type;

public class MobileEmulation {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false)
				);

		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setDeviceScaleFactor(2)
				.setHasTouch(true)
				.setIsMobile(true)
				.setViewportSize(390, 844));

		context.grantPermissions(Arrays.asList("notifications"));

		// Open page and load URL
		Page page = context.newPage();

		// Load the page with URL
		page.navigate("https://www.gps-coordinates.net/my-location");
		page.waitForLoadState(LoadState.NETWORKIDLE);

		String innerText = page.locator("#addr").innerText();
		System.out.println(innerText);

	}

}
