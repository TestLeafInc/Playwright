package week2.day2;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserActions {


	public static void main(String[] args) {
		
		// Get the screen resolution from graphics
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		// Initialize Playwright
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)
				);

		// Open a new page
		Page page = browser.newPage();
		
	
		// load the url
		page.navigate("http://leaftaps.com/opentaps");
		
		// maximize window
		page.setViewportSize(width, height);

		// Find the username and enter the value
		page.locator("id=username").type("demosalesmanager");

		// Find the password and enter the value
		page.locator("#password").type("crmsfa");

		// Find the login and click
		page.locator(".decorativeSubmit").click();
		
		// Click on the CRM/SFA
		page.locator("text=CRM/SFA").click();
		
		// go backward
		page.goBack();
		
		// title
		String title = page.title();
		System.out.println(title);
		
		// url
		String url = page.url();
		System.out.println(url);
		
		// forward
		page.goForward();
		
		pw.close();
	}

}
