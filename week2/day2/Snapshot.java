package week2.day2;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Snapshot {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setStorageStatePath(Paths.get("login_leaftaps_democsr.json")));
		
		Page page = context.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		
	
		// Click on the CRM/SFA
		page.locator("text=CRM/SFA").click();
		
		// Click Leads Tab
		page.locator("a:has-text('Leads')").click();
		
		// Click Create Lead
		page.locator("text=Create Lead").click();
		
		// Take a snaphot
		page.screenshot(new Page.ScreenshotOptions()
				.setFullPage(true)
				.setPath(Paths.get("snaps/snap1.png")));
		
		// Type Company Name, First Name and Last Name
		page.locator("#createLeadForm_companyName").type("TestLeaf");
		page.locator("#createLeadForm_firstName").type("Babu");
		page.locator("#createLeadForm_lastName").type("Manickam");
		
		// Find how many options
		Locator options = page.locator("#createLeadForm_dataSourceId > option");
		System.out.println(options.count());
		
		// find all the inner texts
		List<String> allInnerTexts = options.allInnerTexts();
		for (int i = 0; i < allInnerTexts.size(); i++) {
			System.out.println(allInnerTexts.get(i));
			if(allInnerTexts.get(i).equals("Employee")) {
				// click
				break;
			}
		}
		
		// Select some dropdown option
		page.locator("#createLeadForm_dataSourceId").selectOption("LEAD_DIRECTMAIL");
		
		// Click Create Lead Button
		page.locator(".smallSubmit").click();
		
		// Print the status of the created lead
		String status = page.locator("#viewLead_statusId_sp").innerText();
		System.out.println(status);
		
		// Close browser
		browser.close();
		
		// Playwright close
		pw.close();
		
		
		
		
		
		
		
		
	}

}
