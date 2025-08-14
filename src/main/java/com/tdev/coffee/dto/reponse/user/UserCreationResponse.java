package com.tdev.coffee.dto.reponse.user;

public class UserCreationResponse {
    private String username;
    private String gmail;

    public UserCreationResponse(String username, String gmail) {
        this.username = username;
        this.gmail = gmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
