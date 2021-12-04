package study.ecos.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StudyEcosApi {
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpRequest sampleRequest = HttpRequest.newBuilder()
			.GET()
			.uri(URI.create("http://ecos.bok.or.kr/api/KeyStatisticList/sample/json/kr/1/10/"))
			.build();
			
		HttpResponse<String> sampleResponse = HttpClient.newHttpClient().send(sampleRequest, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(sampleResponse.body());
	}
}
