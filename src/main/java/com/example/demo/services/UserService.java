package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userDao;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userDao.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userDao.save(user);
    }

    public Optional<UserModel> findByIdUser (Long id) {
        return userDao.findById(id);
    }

    public ArrayList<UserModel> findByPriorityUser (Integer priority) {
        return userDao.findByPriority(priority);
    }

    public boolean deleteUser(Long id) {
        try {
            userDao.deleteById(id);
            return true;
        } catch (Exception e) {
            log.info("*** User not deleted in data base because user not found.");
        }
        return false;
    }
}