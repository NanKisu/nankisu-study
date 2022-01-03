import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSRCrawlerWithSelenium {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nankisu\\eclipse-workspace-mojee\\CSRCrawlerWithSelenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ssrcsr-study.s3.ap-northeast-2.amazonaws.com/CSR_Page.html");
		Document doc = Jsoup.parse(driver.getPageSource());
		Elements span = doc.select("span");
		System.out.println(span);
	}
}
