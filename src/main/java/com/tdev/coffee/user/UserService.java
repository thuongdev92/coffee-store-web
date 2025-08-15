package com.tdev.coffee.user;

import com.tdev.coffee.user.dto.response.UserResponse;
import com.tdev.coffee.user.dto.request.UserCreationRequest;
import com.tdev.coffee.user.dto.request.UserUpdateRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    // Can use @Autowired, but better to use constructor injection so the bean can be final.
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserCreationRequest request) {

        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setGender(request.getGender());
        user.setGmail(request.getGmail());
        user.setPhone(request.getPhone());

        UserEntity saved = userRepository.save(user);
        return new UserResponse(saved.getId(), saved.getUsername(), saved.getGmail());
    }

    public UserResponse getUserResponse(String userId) {
        return userRepository.findById(userId)
                .map(userEntity -> new UserResponse(userEntity.getId(), userEntity.getUsername(), userEntity.getGender()))
                .orElseThrow(() -> new RuntimeException("ID user not found"));
    }

    public List<UserResponse> getAllUsersResponse() {
        return userRepository.findAll().stream()
                .map(userEntity -> new UserResponse(userEntity.getId(), userEntity.getUsername(), userEntity.getGender()))
                .toList();
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        UserEntity user = getUserEntity(userId);

        user.setPassword(request.getPassword());
        user.setGender(request.getGender());
        user.setGmail(request.getGmail());
        user.setPhone(request.getPhone());

        UserEntity saved = userRepository.save(user);
        return new UserResponse(saved.getId(), saved.getUsername(), saved.getGender());
    }

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "delete successfully !!!";
    }


    public UserEntity getUserEntity(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
