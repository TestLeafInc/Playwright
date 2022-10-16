package week2.day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CreateLead {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		// maximize your browser 
		page.setViewportSize(1200, 800);
		// Timeout ==> 30 sec !
		
		// Identify an element (locators)
		/* 
		 * text
		 * css (more of this)
		 * xpath
		 * id
		 * 
		 */
		
		// Find the username and enter the value
		page.locator("id=username").type("demosalesmanager");
		page.keyboard().press("Tab");
		Locator locator = page.locator("*:focus");
		String attribute = locator.getAttribute("name");
		
		// Find the password and enter the value
		page.locator("#password").type("crmsfa");
		
		 locator = page.locator("*:focus");
		 attribute = locator.getAttribute("name");
		
		// Find the login and click
		page.locator(".decorativeSubmit").click();
		
		// Click on the CRM/SFA
		page.locator("text=CRM/SFA").click();
		
		// Click Leads Tab
		page.locator("a:has-text('Leads')").click();
		
		// Click Create Lead
		page.locator("text=Create Lead").click();
		
		// Type Company Name, First Name and Last Name
		page.locator("#createLeadForm_companyName").type("TestLeaf");
		page.locator("#createLeadForm_firstName").type("Babu");
		page.locator("#createLeadForm_lastName").type("Manickam");
		
		// Click Create Lead Button
		page.locator(".smallSubmit").click();
		
		// Print the status of the created lead
		String status = page.locator("#viewLead_statusId_sp").innerText();
		System.out.println(status);
		
		// Close browser
		//browser.close();
		
		
		
		
		
		
		
		
		
		
	}

}
