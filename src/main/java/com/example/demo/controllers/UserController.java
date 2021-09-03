package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/User")
public class UserController {
    
    @Autowired
    UserService service;

    @GetMapping("/GetUsers")
    public ArrayList<UserModel> getUsers() {
        return this.service.getUsers();
    }

    @PostMapping("/SaveUser")
    public UserModel saveUser (@RequestBody UserModel user) {
        return this.service.saveUser(user);
    }

    @GetMapping("/GetUserById/{id}")
    public Optional<UserModel>  getUserById(@PathVariable("id") Long id) {
        return this.service.findByIdUser(id);
    }

    @GetMapping("/GetUserByPriority")
    public ArrayList<UserModel> getUserByPriority(@RequestParam("priority") Integer priority) {
        return this.service.findByPriorityUser(priority);
    }

    @DeleteMapping(path = "/deleteUserById/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        boolean ok = this.service.deleteUser(id);
        return (ok)? "Se elimino el usuario con el id = " + id: "No se pudo eliminar el usuario con el id = " + id;
    }

}
