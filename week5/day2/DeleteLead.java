package week5.day2;

import java.util.Iterator;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DeleteLead extends BaseClass{

	@Test()
	public void deleteLead() throws InterruptedException {
		
		// Click Find Leads Menu (on the left)
		page.locator("//a[text()='Find Leads1']").click();
		
		// Find and Type First Name ("Babu")
		page.locator("(//input[@name='firstName'])[3]").type("Babu");
		
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
		
	
	}

}
