package starter.status;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.response.Response;
import org.apache.log4j.Logger;
public class BDDStyledUtils extends TestBase{
	public static Map<String, String> data=new HashMap<String, String>();
	public static JSONObject jsonObject;
	public static Response response;
	public static String responseBody;
	public static Logger logger = Logger.getLogger(BDDStyledUtils.class);
	public static void AddPlaceInGoogleMap() {
		logger.info("****************************** starting POST test case *****************************************");
		response=given()
				.baseUri(base_Url)
				.basePath(post_url)
				.queryParam("key", keyValue)
				.body(file)
				.when()
				.post();

		response
		.then().assertThat().statusCode(RESPONSE_STATUS_CODE_200);
		responseBody=response.then().extract().body().asString();

		placeId=response.jsonPath().get("place_id");
		System.out.println("place_id : "+placeId);
		System.out.println("Add Response Body : " +responseBody);
		logger.info("****************************** ending POST test case *****************************************");
	}
	
    public static void DisplayPlaceInGoogleMap(){
    	logger.info("****************************** starting GET test case *****************************************");
		System.out.println("place_id : "+placeId);
		response=given()
				.baseUri(base_Url)
				.basePath(get_url)
				.queryParam("place_id", placeId )
				.queryParam("key", keyValue)
				.get();

		response
		.then().assertThat().statusCode(RESPONSE_STATUS_CODE_200);
	
		responseBody=response.then().extract().body().asString();

		System.out.println("Get Response Body : " +responseBody);
		logger.info("****************************** ending GET test case *****************************************");
    }

public static void UpdatePlaceInGoogleMap() {
	logger.info("****************************** starting PUT test case *****************************************");
		System.out.println("place_id : "+placeId);
		
		data.put("place_id", placeId);
		data.put("address", "70 winter walk, USA");
		data.put("key", "qaclick123");
		data.put("body", "this is REST Assured Tutorial");
		jsonObject = new JSONObject(data);
		response=given()
				.baseUri(base_Url)
				.basePath(update_url)
				.queryParam("key", keyValue)
				.body(jsonObject)
				.when()
				.put();

		response
		.then().assertThat().statusCode(RESPONSE_STATUS_CODE_200);
		responseBody=response.then().extract().body().asString();

		System.out.println("Update Response Body : " +responseBody);
		DisplayPlaceInGoogleMap();
		logger.info("****************************** ending PUT test case *****************************************");
	}

	
	public static void DeletePlaceInGoogleMap() {
		logger.info("****************************** starting DELETE test case *****************************************");
		System.out.println("place_id : "+placeId);
		data.put("key", "qaclick123");
		response=given()
				.baseUri(base_Url)
				.basePath(delete_url)
				.queryParam("key", keyValue)
				.body(jsonObject)
				.when()
				.delete();

		response
		.then().assertThat().statusCode(RESPONSE_STATUS_CODE_200);
		responseBody=response.then().extract().body().asString();

		System.out.println("Delete Response Body : " +responseBody);
		logger.info("****************************** ending DELETE test case *****************************************");
	}





}
