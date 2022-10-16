package week4.day1;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class CreateLead {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
		
		BrowserContext context = browser.newContext();
		
		// Enable tracing
		context.tracing().start(
					new Tracing.StartOptions()
					.setName("CreateLead_Tracing")
				//	.setScreenshots(true)
					.setSnapshots(true)
					.setTitle("CreateLead")
				);
		
		
		Page page = context.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		
		// Find the username and enter the value
		page.locator("id=username").type("demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.locator(".decorativeSubmit").click();
		page.locator("text=CRM/SFA").click();
		page.locator("a:has-text('Leads')").click();
		page.locator("text=Create Lead").click();
		page.locator("#createLeadForm_companyName").type("TestLeaf");
		page.locator("#createLeadForm_firstName").type("Babu");
		page.locator("#createLeadForm_lastName").type("Manickam");
		page.locator(".smallSubmit").click();
		
		// Print the status of the created lead
		String status = page.locator("#viewLead_statusId_sp").innerText();
		System.out.println(status);
		
		// End tracing
		context.tracing().stop(
					new Tracing.StopOptions().setPath(Paths.get("traces/createlead_headless.zip"))
				);
		
		// Close browser
		pw.close();
		
		
		
		
		
		
		
	}

}
