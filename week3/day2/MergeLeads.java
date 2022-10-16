package week3.day2;

import org.testng.annotations.Test;
import com.microsoft.playwright.*;

public class MergeLeads {

	@Test
	public void edit() throws InterruptedException {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();
		page.onDialog(dialog -> {
	        System.out.println(dialog.message());
	        dialog.accept();
	      });
		page.navigate("http://leaftaps.com/opentaps");
		page.locator("#username").type("demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.locator("//*[@class='decorativeSubmit']").click();
		page.locator("//a[contains(text(),'CRM/SFA')]").click();
		page.locator("//a[text()='Leads']").click();
		page.locator("//a[text()='Merge Leads']").click();
		
		Page newPage = context.waitForPage(() -> {
			page.locator("(//span[text()='From Lead']/following::a)[1]").click();
		});
		System.out.println(newPage.evaluate("location.href"));
		
		newPage.locator("(//label[text()='First name:']/following::input)[1]").type("Babu");
		newPage.locator("//button[text()='Find Leads']").click();
		newPage.locator("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").click();

		String value = page.locator("#partyIdFrom").getAttribute("value");
		System.out.println(value);
		
		newPage = context.waitForPage(() -> {
			page.locator("(//span[text()='To Lead']/following::a)[1]").click();
		});
		
		
		System.out.println(newPage.evaluate("location.href"));
		newPage.locator("(//label[text()='First name:']/following::input)[1]").type("Hari");
		newPage.locator("//button[text()='Find Leads']").click();
		newPage.locator("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").click();
	
		Locator locator = page.locator(".buttonDangerous");
		locator.click();
		
		// no data found
		
	
	}
}
