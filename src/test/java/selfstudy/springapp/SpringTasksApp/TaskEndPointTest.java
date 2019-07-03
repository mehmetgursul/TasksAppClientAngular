package selfstudy.springapp.SpringTasksApp;


import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.RestAssured;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import selfstudy.springapp.SpringTasksApp.domain.Task;

public class TaskEndPointTest{

    @BeforeClass
    public static void setup() {

        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;
    }

    @Test
    public void test01CanCreateUser() {
        JSONObject user = new JSONObject();

        Task task = new Task(11L,"Creat Spring-1 Boot App", null,true);

        given()
                .contentType("application/json")
                .body(task.toString())
                .when()
                .post("/tasks/save")
                .then().statusCode(200);
    }



}