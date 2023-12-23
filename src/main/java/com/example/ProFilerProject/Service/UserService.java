package com.example.ProFilerProject.Service;

import com.example.ProFilerProject.Entity.User;
import com.example.ProFilerProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void createUser(User user){
        userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.getReferenceById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
