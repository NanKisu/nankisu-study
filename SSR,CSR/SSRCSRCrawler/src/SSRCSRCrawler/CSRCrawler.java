package SSRCSRCrawler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CSRCrawler {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		URI requstUrl =  new URI("https://ssrcsr-study.s3.ap-northeast-2.amazonaws.com/CSR_Page.html");
		HttpRequest request = HttpRequest.newBuilder(requstUrl).GET().build();
		String response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString()).body();
		Document doc = Jsoup.parse(response);
		Elements span = doc.select("span");
		System.out.println(span);
	}

}
