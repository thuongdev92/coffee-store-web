package com.tdev.coffee.dto.reponse.user;

public class UserUpdateResponse {
    private String username;
    private String password;
    private String gender;
    private String gmail;
    private long phone;

    public UserUpdateResponse(String username, String password, String gender, String gmail, long phone) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.gmail = gmail;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
