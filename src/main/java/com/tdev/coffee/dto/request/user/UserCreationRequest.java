package com.tdev.coffee.dto.request.user;

import com.tdev.coffee.validation.username.UniqueUsername;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserCreationRequest {

    @NotBlank(message = "Username không được để trống")
    @UniqueUsername
    @Pattern(
            regexp = "^[a-zA-Z0-9]{6,16}$",
            message = "Username phải từ 6 đến 16 ký tự, chỉ chứa chữ và số, không chứa ký tự đặc biệt"
    )
    private String username;


    @NotBlank(message = "Password không được để trống")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at lest 8 characters, có chữ hoa, thường, number and character đặc biệt"
    )
    private String password;
    private String gender;

    @NotBlank(message = "Gmail không được để trống")
    @Pattern(
            regexp = "^[a-zA-Z0-9]+@gmail\\.com$",
            message = "Sai định dạng Gmail"
    )
    private String gmail;

    private long phone;

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
