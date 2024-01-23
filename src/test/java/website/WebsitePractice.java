package website;


	

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class WebsitePractice {

		public static void main(String[] args) {
			// Step 1: Create a list of URLs
			List<String> urls = new ArrayList<>();
			urls.add("https://kairostech.com/about-us/");
			urls.add("https://klabs.kairostech.com/kitap-for-total-automation/");
			urls.add("https://kairostech.com/contact-us/");

			// Step 2: Shuffle the list to randomize the order
			Collections.shuffle(urls);

			// Step 3: Iterate through the list and automate each URL
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			for (String url : urls) {
				try {
					driver.get(url);
					String actualTitle = driver.getTitle();
					String expectedTitle = getExpectedTitle(url);

					// Verify the title
					if (actualTitle.equals(expectedTitle)) {
						System.out.println("Title verification passed for " + url + "! Actual Title: " + actualTitle);
					} else {
						System.out.println("Title verification failed for " + url + ". Actual Title: " + actualTitle);
					}

					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			driver.quit();
		}

		private static String getExpectedTitle(String url) {

			if (url.equals("https://kairostech.com/about-us/")) {
				return "About Us | Kairos Technologies";
			} else if (url.equals("https://klabs.kairostech.com/kitap-for-total-automation/")) {
				return "KiTAP for Total Automation | Kairos Technologies";
			} else if (url.equals("https://kairostech.com/contact-us/")) {
				return "Contact us | Kairos Technologies";
			}
			return "Default Title";
		}
	}


