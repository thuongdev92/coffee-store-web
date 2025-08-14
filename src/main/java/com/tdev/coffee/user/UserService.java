package com.tdev.coffee.user;

import com.tdev.coffee.user.dto.UserCreationResponse;
import com.tdev.coffee.user.dto.UserUpdateResponse;
import com.tdev.coffee.user.dto.UserCreationRequest;
import com.tdev.coffee.user.dto.UserUpdateRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    // Can use @Autowired, but better to use constructor injection so the bean can be final.
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserCreationResponse createUser(UserCreationRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setGender(request.getGender());
        user.setGmail(request.getGmail());
        user.setPhone(request.getPhone());

        User saved = userRepository.save(user);
        return new UserCreationResponse(saved.getUsername(), saved.getGmail());
    }

    public User getUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("ID user not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserUpdateResponse updateUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setGender(request.getGender());
        user.setGmail(request.getGmail());
        user.setPhone(request.getPhone());

        User saved = userRepository.save(user);
        return new UserUpdateResponse(saved.getUsername(), saved.getPassword(), saved.getGender(), user.getGmail(), user.getPhone());
    }

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "delete successfully !!!";
    }
}
