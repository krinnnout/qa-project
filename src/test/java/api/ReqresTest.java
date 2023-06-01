package api;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest(){
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users?page=2")
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
}
