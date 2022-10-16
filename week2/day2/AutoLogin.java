package week2.day2;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoLogin {

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
		
		// Click Find Leads Menu (on the left)
		page.locator("//a[text()='Find Leads']").click();
		
		// Find and Type First Name ("Babu")
		page.locator("(//input[@name='firstName'])[3]").type("Babu");
		
		// Click Find Leads Button
		page.locator("//button[text()='Find Leads']").click();

		// Click on the first matching link (xpath --> )
		page.locator("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		
		// Click Edit 
		page.locator("text=Edit").click();
		
		// Clear the existing value 
		Locator firstName = page.locator("id=updateLeadForm_firstName");
		
		firstName.fill("");
		
		// Type your name 
		firstName.type("Hari");
		
		// Click Update
		page.locator("text=Update").click();
		
		// Confirm name got changed !!
		String text = page.locator("#viewLead_firstName_sp").innerText();
		System.out.println(text);
		
		
		
		
		
		
		
		
	}

}
