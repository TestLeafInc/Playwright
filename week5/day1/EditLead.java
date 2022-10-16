package week5.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class EditLead extends BaseClass{

	// packagename.classname.methodname
	@Test(dependsOnMethods = "week5.day1.CreateLead.createLead")
	public void editLead(){
		
		// Click Find Leads Menu (on the left)
		page.locator("//a[text()='Find Leads']").click();
		
		// Find and Type First Name ("Babu")
		page.locator("(//input[@name='firstName'])[3]").type("Rahul");
		
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
