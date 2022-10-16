package week2.day1;

import java.util.Iterator;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		
		// Find the username and enter the value
		page.locator("id=username").type("demosalesmanager");
		
		// Find the password and enter the value
		page.locator("#password").type("crmsfa");
		
		// Find the login and click
		page.locator(".decorativeSubmit").click();
		
		// Click on the CRM/SFA
		page.locator("text=CRM/SFA").click();
		
		// Click Leads Tab
		page.locator("a:has-text('Leads')").click();
		
		// Click Find Leads Menu (on the left)
		page.locator("//a[text()='Find Leads']").click();
		
		// Click on Phone tab
		page.locator("//span[text()='Phone']").click();
		
		// Type the phone number
		Locator phone = page.locator("[name='phoneNumber']");
		
		phone.fill("");
		phone.type("9");
		
		// Click Find Leads button
		page.locator("//button[text()='Find Leads']").click();

		// Click the first matching result
		Locator elements = page.locator("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		
		// Get the count
		int count = elements.count();
		System.out.println("Number of matches "+count);
		
		// Wait condition
		Thread.sleep(2000);
		
		// Click on first
		Locator eleFirst = elements.first();
		String leadId = eleFirst.innerText();
		eleFirst.click();
		
		// Click on Delete button
		page.click(".subMenuButtonDangerous");
		
		// Click find leads menu
		page.locator("//a[text()='Find Leads']").click();
		
		// Type the lead number
		page.type("[name=id]", leadId);
		
		// Click Find Leads button
		page.locator("//button[text()='Find Leads']").click();
		
		// Confirm No records found
		String innerText = page.locator(".x-paging-info").innerText();
		System.out.println(innerText);
		
		// at end of every test - recommended to use this !!
		pw.close();
		
		
		
	}

}
