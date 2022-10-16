package week3.day2;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;

public class FileDownload {
	
	public static void main(String[] args) throws InterruptedException {
		

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();
		page.navigate("https://www.leafground.com/file.xhtml");
		
		Download download = page.waitForDownload( () -> {
			page.locator("(//h5[text()='Basic Download']/following::span)[2]").click();
		});
		
		Path path = download.path();
		
		download.saveAs(Paths.get("/downloads"));
		
		System.out.println(path.getRoot());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
