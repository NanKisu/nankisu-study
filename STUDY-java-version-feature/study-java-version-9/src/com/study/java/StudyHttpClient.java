package com.study.java;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class StudyHttpClient {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		HttpRequest request = HttpRequest.newBuilder()
		  .uri(new URI("https://postman-echo.com/get"))
		  .GET()
		  .build();

		HttpResponse<String> response = HttpClient.newHttpClient()
		  .send(request, HttpResponse.BodyHandler.asString());
		
		System.out.println(response.body());
	}

}
