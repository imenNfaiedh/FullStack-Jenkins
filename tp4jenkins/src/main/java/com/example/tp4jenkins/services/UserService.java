package com.example.tp4jenkins.services;

import com.example.tp4jenkins.entities.User;
import com.example.tp4jenkins.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(String firstname, String lastname){
        return  this.userRepository.save(new User(firstname,lastname));
    }

    public void deleteUser(Long id){
        this.userRepository.deleteById(id);
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
}
