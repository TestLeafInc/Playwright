package week4.day1;

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

public class GeoLocation {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		
		/*List<String> lst = new ArrayList<>();
		lst.add("geolocation"); */

		// Browser Context
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions()
				.setGeolocation(12.9767936,77.590082)
				.setPermissions(Arrays.asList("geolocation"))
				);

		// Open page and load URL
		Page page = context.newPage();
		
		// Load the page with URL
		page.navigate("https://www.gps-coordinates.net/my-location");
		page.waitForLoadState(LoadState.NETWORKIDLE);

		String innerText = page.locator("#addr").innerText();
		System.out.println(innerText);

	}

}
