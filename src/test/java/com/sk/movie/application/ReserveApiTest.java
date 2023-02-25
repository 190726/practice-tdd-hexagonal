package com.sk.movie.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.sk.movie.adapter.in.web.model.ReserveRequest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@Tag("intergration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReserveApiTest {
	
	@LocalServerPort
	int port;
	
	@BeforeEach
	void init() {
		RestAssured.port = port;
	}
	
	@Test
	void reserveApiTest() throws Exception {
		//given
		String screenId = "0001";
		int numberUsers = 2;
		ReserveRequest request = new ReserveRequest(screenId, numberUsers);
		
		//when
		ExtractableResponse<Response> response = RestAssured.given().log().all()
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.body(request)
					.when()
					.post("/reserve")
					.then()
					.log().all().extract();
		//then
		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
	}
}
