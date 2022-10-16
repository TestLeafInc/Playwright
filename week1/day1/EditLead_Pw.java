package week1.day1;


import org.testng.annotations.Test;
import com.microsoft.playwright.*;

public class EditLead_Pw {

	@Test
	public void edit() throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("chrome")
				.setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("http://leaftaps.com/opentaps");
		page.locator("#username").type("demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.locator("//*[@class='decorativeSubmit']").click();
		page.locator("//a[contains(text(),'CRM/SFA')]").click();
		page.locator("//a[text()='Leads']").click();
		page.locator("//a[text()='Find Leads']").click();
		page.locator("(//span[text()='Advanced']/following::input)[2]").type("Babu");
		page.locator("//button[text()='Find Leads']").click();
		
		page.locator("(//td[contains(@class,'x-grid3-col x-grid3-cell')]//div/a)[1]").click();
		page.locator("//a[text()='Edit']").click();
		page.locator("#updateLeadForm_companyName").type("TestLeaf");
		page.locator("text=Update").click();
		String innerText = page.locator("#viewLead_companyName_sp").innerText();
		System.out.println(innerText);
		
		
		
		
	}
}
