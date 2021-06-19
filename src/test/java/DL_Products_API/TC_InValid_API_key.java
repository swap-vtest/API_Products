package DL_Products_API;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsableMethods;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

//import org.json.Assertions;

public class TC_InValid_API_key {

	public static Response response;

	// @SuppressWarnings("deprecation")
	@Test(dataProvider = "RCData")

	public void APIResponse(String aisle, String isbn) throws IOException {

		RestAssured.baseURI = "http://develop.zoop.one/api/product";

		RequestSpecification request = RestAssured.given();

		// request.header("Postman-Token","<calculated when request is sent>");

		request.header("Content-Type", "application/json");

		// request.header("Content-Length","<calculated when request is sent>");
		// request.header("Host","<calculated when request is sent>");
		request.header("User-Agent", "PostmanRuntime/7.28.0");
		request.header("Accept", "*/*");
		request.header("Accept-Encoding", "gzip, deflate, br");
		request.header("Connection", "keep-alive");
		request.header("auth", "false");
		request.header("app-id", "60b603efac6a28001c7531a9");
		request.header("app-key", "1V59B66N-A4KMYN4-QAW3640-Z9P0SQP");
		// #######################################################
		//	request.header("app-key-stag","673R00W-Y7MM7VV-MSK0XP8-D3HZE19");
		//	request.header("app-id-stag","60a2354e1037b2001df3e346");
		//	request.header("app-key-stag","http://staging.zoop.one/api/product");

		// response = request.post("/v1/product/in/vehicle/rc/lite/test").then()
		/***
		 * response = request.body("{\r\n" + " \"mode\": \"sync\",\r\n" + " \"data\":
		 * {\r\n" + " \"vehicle_registeration_number\": \"WB34AX6704\",\r\n" + "
		 * \"consent\": \"Y\",\r\n" + " \"consent_text\": \"RC Lite is Verified by
		 * author\"\r\n" + " }\r\n" +
		 * "}").and().post("/v1/product/in/vehicle/rc/lite/verify").then().extract().response();
		 ***/
		

		/**/ String response = request.body(payload_DL.Addbook(aisle, isbn)).when()/**/
				
				// .post("/v1/product/in/vehicle/rc/lite/test").then().assertThat().statusCode(200).log().all().extract().response().asString();
				.post("/v1/product/in/identity/dl/advance/test").then().assertThat().log().all().extract().response()
				.asString();

		// assertEquals(201, response.statusCode());

		JsonPath js = ReUsableMethods.rawToJson(response);

		String name = js.get("result.owner_name");
		String msg = js.get("response_message");
		String bill = js.get("metadata.billable");

		String id = js.get("response_code");

		System.out.println("Name is :" + name);
		System.out.println("Response Code is :" + id);
		System.out.println("Response Message is :" + msg);
		System.out.println("Billable is :" + bill);

		// Assert.assertTrue(id.equals(100));

		assertEquals("100", id);

	}

	@DataProvider(name = "RCData")

	public Object[][] getData() {
		return new Object[][] { { "RJ20 20140004739", "Approve the values" } };

	}
}
