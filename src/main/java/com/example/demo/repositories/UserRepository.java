package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import com.example.demo.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByPriority(Integer priority);

    public abstract ArrayList<UserModel> findByName(String name);

    public abstract ArrayList<UserModel> findByEmail(String email);
}