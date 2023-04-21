package com.practice;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAPI {

	private static final String BASE_URI = "http://localhost:8081";

	public static void main(String[] args) {
		Response response = given().when().get(BASE_URI + "/posts/1");

		System.out.println(response.getBody().asPrettyString());

		Map<String, Object> requestParams = new HashMap<>();
		requestParams.put("name", "nakkeeran");
		requestParams.put("email", "nakkeeran@ample.com");
		requestParams.put("age", 30);

		Response post = given().contentType(ContentType.JSON).body(requestParams).when().post(BASE_URI + "/posts");

		System.out.println(post.getBody().asPrettyString());

		Map<String, Object> updateParams = new HashMap<>();
		updateParams.put("name", "Jane Doe");
		updateParams.put("email", "janedoe@example.com");
		updateParams.put("age", 35);

		Response put = given().contentType(ContentType.JSON).body(updateParams).when().put(BASE_URI + "/users/1");

		System.out.println(put.getBody().asPrettyString());

		// PATCH method
		Map<String, Object> patchParams = new HashMap<>();
		patchParams.put("email", "jane_doe@example.com");

		Response patch = given().contentType(ContentType.JSON).body(patchParams).when().patch(BASE_URI + "/users/1");

		// DELETE method
		Response delete = given().when().delete(BASE_URI + "/users/1");

	}

}
