package com.example.TaskTracker.services.impl;
import java.util.List;
import java.util.Optional;
import com.example.TaskTracker.entities.User;
import com.example.TaskTracker.repositories.UserRepository;
import com.example.TaskTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new RuntimeException("User not found for id : " + id);
        }
        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        User targetUser = getUserById(id);
        targetUser.setUsername(user.getUsername());
        targetUser.setEmail(user.getEmail());
        return userRepository.save(targetUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
