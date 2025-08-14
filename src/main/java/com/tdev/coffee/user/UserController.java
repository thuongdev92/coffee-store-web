package com.tdev.coffee.user;

import com.tdev.coffee.user.dto.UserCreationResponse;
import com.tdev.coffee.user.dto.UserUpdateResponse;
import com.tdev.coffee.user.dto.UserCreationRequest;
import com.tdev.coffee.user.dto.UserUpdateRequest;
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

    @GetMapping("/{id}")
    User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @GetMapping
    List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    UserUpdateResponse updateUSer(@PathVariable String userId,@RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
}
