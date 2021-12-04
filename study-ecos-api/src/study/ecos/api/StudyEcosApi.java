package study.ecos.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StudyEcosApi {
	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
		HttpRequest sampleRequest = HttpRequest.newBuilder()
			.GET()
			.uri(URI.create("http://ecos.bok.or.kr/api/KeyStatisticList/sample/json/kr/1/10/"))
			.build();
			
		HttpResponse<String> sampleResponse = HttpClient.newHttpClient().send(sampleRequest, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(sampleResponse.body());
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(sampleResponse.body());
		JSONObject KeyStatisticList = (JSONObject)jsonObject.get("KeyStatisticList");
		System.out.println(KeyStatisticList.get("list_total_count"));
	}
}
