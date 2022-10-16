package week5.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CreateLead extends BaseClass{

	@Test(invocationCount = 2)
	public void createLead() {
		
		// Click Create Lead
		page.locator("text=Create Lead").click();
		
		// Type Company Name, First Name and Last Name
		page.locator("#createLeadForm_companyName").type("TestLeaf");
		page.locator("#createLeadForm_firstName").type("Rahul");
		page.locator("#createLeadForm_lastName").type("Manickam");
		
		// Click Create Lead Button
		page.locator(".smallSubmit").click();
		
		// Print the status of the created lead
		String status = page.locator("#viewLead_statusId_sp").innerText();
		System.out.println(status);
		
	}

}
