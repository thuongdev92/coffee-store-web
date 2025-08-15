package com.tdev.coffee.user;

import com.tdev.coffee.user.dto.response.UserResponse;
import com.tdev.coffee.user.dto.request.UserCreationRequest;
import com.tdev.coffee.user.dto.request.UserUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    UserResponse createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable String userId) {
        return userService.getUserResponse(userId);
    }

    @GetMapping
    List<UserResponse> getAllUsers() {
        return userService.getAllUsersResponse();
    }

    @PutMapping("/{userId}")
    UserResponse updateUSer(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
}
