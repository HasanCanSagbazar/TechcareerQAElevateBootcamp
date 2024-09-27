import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class PetStoreApi {

    @Test
    public void createUserInfo() {
        String payload = "{\n" +
                "  \"id\": 123456789,\n" +
                "  \"username\": \"johnDoe\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"email\": \"johndoe@email.com\",\n" +
                "  \"password\": \"132546\",\n" +
                "  \"phone\": \"+90454156187\",\n" +
                "  \"userStatus\": 0\n" +
                "}";


        RestAssured.given().
                body(payload).
                contentType(ContentType.JSON).
                when().
                post("https://petstore.swagger.io/v2/user").
                then().
                statusCode(200);

    }

    @Test
    public void updateUserInfo() {
        String payload = "{\n" +
                "  \"id\": 123456789,\n" +
                "  \"username\": \"johnDoe2\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"email\": \"johndoe@email.com\",\n" +
                "  \"password\": \"132546\",\n" +
                "  \"phone\": \"+90454156187\",\n" +
                "  \"userStatus\": 0\n" +
                "}";


        RestAssured.given().
                body(payload).
                contentType(ContentType.JSON).
                when().
                put("https://petstore.swagger.io/v2/user/johnDoe").
                then().
                statusCode(200);

    }

    @Test
    public void getUserInfo() {
        RestAssured.get("https://petstore.swagger.io/v2/user/johnDoe2");
    }

    @Test
    public void deleteUserInfo(){

        RestAssured.given().
                contentType(ContentType.JSON).
                when().
                delete("https://petstore.swagger.io/v2/user/johnDoe2").
                then().
                statusCode(200);
    }

    @Test
    public void logIn(){
        String payload = "{\n" +
                "  \"username\": \"johnDoe2\",\n" +
                "  \"password\": \"132546\",\n" +
                "}";

        RestAssured.given().
                contentType(ContentType.JSON).
                queryParam(payload).
                when().
                get("https://petstore.swagger.io/v2/user/login").
                then().
                statusCode(200);
    }


    @Test
    public void logOut(){
        RestAssured.get("https://petstore.swagger.io/v2/user/logout");
    }
}
