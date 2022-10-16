package week4.day1;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

import jdk.nashorn.internal.codegen.types.Type;

public class Screenshot {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		
		 BrowserContext context = browser.newContext(new Browser.NewContextOptions()
			        .setDeviceScaleFactor(2)
			        .setHasTouch(true)
			        .setIsMobile(true)
			        .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1")
			        .setViewportSize(414, 715));
		

		// Open page and load URL
		Page page = context.newPage();
		
		// Load the page with URL
		page.navigate("https://redbus.in");
		
		page.screenshot(
				new Page.ScreenshotOptions()
				.setFullPage(true)
				.setPath(Paths.get("snaps/lg_page.png")));
		
		/*
		page.locator("#message").screenshot(
				new Locator.ScreenshotOptions()
				.setPath(Paths.get("snaps/lg_element.png"))
				); */
		
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		byte[] screenshot = page.screenshot();
		byte[] encode = Base64.getEncoder().encode(screenshot);
		System.out.println(new String(encode));
		

	}

}
