package apiauto;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APITest {

    @Test
    public void getUserTest() {
        //Define the URL
        RestAssured.baseURI = "https://reqres.in/";

        //Call get request from path
        given().when().get("api/users?page=1") //Take the page 1, if we take the page 2 we need to change the assert body page to number 2
                .then()
                .log().all() //to print the entire request to screen
                .assertThat().statusCode(200) //assert the status code to be 200 (ok)
                .assertThat().body("page", Matchers.equalTo(1)) //assert that we access the correct page
                .assertThat().body("data.id", Matchers.hasSize(6)); //assert that the data has 6 entries
    }

    @Test
    public void createNewUserTest() {

        //Define the url
        RestAssured.baseURI = "https://reqres.in/";

        //Create POST body with parameter "name" and "job" in JSON format
        String name = "Tane";
        String job = "Student";
        JSONObject jsonObject = new JSONObject(); //Hashmap alternative
        jsonObject.put("name", name);
        jsonObject.put("job", job);

        //Test POST with header that accept JSON format
        given().log().all() //log().all() used to print the entire request to screen
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonObject.toString()) //convert JSON to string format
                .post("api/users")
                .then()
                .assertThat().statusCode(201) //assert that status code to be 201 (OK)
                .assertThat().body("name", Matchers.equalTo(name)) //assert response body name
                .assertThat().body("job", Matchers.equalTo(job)) //assert response body job
                .assertThat().body("$", Matchers.hasKey("id")) //assert response body has key "id"
                .assertThat().body("$", Matchers.hasKey("createdAt")); //assert response body has key "createAt"
    }

    @Test
    public void putUserTest() {

        //use PUT to change the entire data
        //Define the url
        RestAssured.baseURI = "https://reqres.in/";

        //Data to update
        int userId = 2;
        String newName = "Lily update";
        String newEmail = "Liliana@reqres.in";

        //test PUT user id -> update first name
        //first get the attributes of user id
        String fName = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.first_name");
        String lName = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.last_name");
        String avatar = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.avatar");
        String email = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.email");
        System.out.println("Name before: " + fName);
        System.out.println("Email before: " + email);

        //Change the first name to updated user
        //change body request with hashmap and convert it to JSON
        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userId); //put userId
        bodyMap.put("email", newEmail); //put user email
        bodyMap.put("avatar", avatar); //put avatar
        bodyMap.put("first_name", newName); //put new user first name
        bodyMap.put("last_name", lName); //put user last name
        JSONObject jsonObject = new JSONObject(bodyMap); //Hashmap alternative

        given().log().all()
                .header("Content-Type", "application/json") //set the header to accept json type
                .body(jsonObject.toString()) //convert JSON to string
                .put("api/users/" + userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName)) //assert the updated name
                .assertThat().body("email", Matchers.equalTo(newEmail));
    }

    @Test
    public void patchUserTest() {
        RestAssured.baseURI = "https://reqres.in/";

        int userId = 3;
        String newName = "Elysiana";

        String fName = given().when().get("api/users/" + userId).getBody().jsonPath().getString("data.first_name");
        System.out.println("Name before: " + fName);

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("first_name", newName);
        JSONObject jsonObject= new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .patch("api/users/" + userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));
    }

    @Test
    public void deleteUserTest() {
        RestAssured.baseURI = "https://reqres.in/";

        int userId = 4;

        given().log().all()
                .when().delete("api/users/" + userId)
                .then()
                .log().all()
                .assertThat().statusCode(204);
    }

    @Test
    public void getSingleUSerTest() {
        RestAssured.baseURI = "https://reqres.in/";

        given().when().get("api/users/5")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void testValidateJsonSchemaGetSingleUser() {
        RestAssured.baseURI = "https://reqres.in/";

        int userToGet = 5;

        File file = new File("src/test/resources/jsonSchema/GetSingleUserSchema.json");

        given().log().all()
                .when().get("api/users/" + userToGet)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
    }
}
