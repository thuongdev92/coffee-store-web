package com.tdev.coffee.controller;

import com.tdev.coffee.dto.reponse.UserCreationResponse;
import com.tdev.coffee.dto.reponse.UserUpdateResponse;
import com.tdev.coffee.dto.request.UserCreationRequest;
import com.tdev.coffee.dto.request.UserUpdateRequest;
import com.tdev.coffee.entity.User;
import com.tdev.coffee.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    UserCreationResponse createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @GetMapping
    List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PutMapping("/{userId}")
    UserUpdateResponse updateUSer(@PathVariable String userId,@RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
}
