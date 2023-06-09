package api;

import io.restassured.http.ContentType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest(){
        Specifications.initSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecification200OK());
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(user-> Assert.assertTrue(user.getAvatar().contains(user.getId().toString())));
        Assert.assertTrue(users.stream().allMatch(user->user.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).toList();
        List<String> ids = users.stream().map(user->user.getId().toString()).toList();

        for(int i = 0; i < avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test
    public void checkRegistrationSuccessfully(){
        Specifications.initSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecification200OK());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        RegisterUser registerUser = new RegisterUser("eve.holt@reqres.in", "pistol");
        RegisterUserSuccess registerUserSuccess = given()
                .body(registerUser)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(RegisterUserSuccess.class);
//        Assert.assertTrue(EqualsBuilder.reflectionEquals(new RegisterUserSuccess(id, token), registerUserSuccess));
        Assert.assertEquals(id, registerUserSuccess.getId());
        Assert.assertEquals(token, registerUserSuccess.getToken());
    }
}
