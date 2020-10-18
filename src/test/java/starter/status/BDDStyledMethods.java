package starter.status;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class BDDStyledMethods {

	static Response response;
	static String responseBody;
    public static void SimpleGETPost(String placeId){
    	response=given()
		.baseUri("https://rahulshettyacademy.com")
		.basePath("/maps/api/place/get/json")
		.queryParam("place_id", placeId )
		.queryParam("key", "qaclick123")
		.get();
    	
    	response
		.then().assertThat().statusCode(200);
		responseBody=response.then().extract().body().asString();

		placeId=response.jsonPath().get("place_id");
		System.out.println("place_id : "+placeId);
		System.out.println("Add Response Body : " +responseBody);
    	
    }

    public static void PerformContainsCollection() {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:3000/posts/")
        .then()
                .body("author", containsInAnyOrder("Karthik KK", "Karthik KK", null)).statusCode(204);
    }

    public static void PerformPathParameter() {

        given()
                .contentType(ContentType.JSON).
        with()
                .pathParams("post", 1).
        when()
                .get("http://localhost:3000/posts/{post}").
        then()
                .body("author", containsString("Karthik KK"));
    }

    public static void PerformQueryParameter(){
        given()
                .contentType(ContentType.JSON)
                .queryParam("id", 1).
        when()
                .get("http://localhost:3000/posts/").
        then()
                .body("author", hasItem("Karthik KK"));
    }

    public static void PerformPOSTWithBodyParameter() {
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("id", "5");
        postContent.put("title", "Robotium course");
        postContent.put("author", "ExecuteAutomation");

        given()
                .contentType(ContentType.JSON).
        with()
                .body(postContent).
        when()
                .post("http://localhost:3000/posts").
        then()
                .body("author", Is.is("ExecuteAutomation"));
    }





}
