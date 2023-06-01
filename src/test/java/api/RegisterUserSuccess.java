package api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterUserSuccess {
    private Integer id;
    private String token;

    @JsonCreator
    public RegisterUserSuccess(@JsonProperty("id") Integer id, @JsonProperty("token") String token) {
        this.id = id;
        this.token = token;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
