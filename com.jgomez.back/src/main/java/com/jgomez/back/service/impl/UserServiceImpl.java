/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.service.impl;

import com.jgomez.back.entities.User;
import com.jgomez.back.persistance.IUserDAO;
import com.jgomez.back.service.IUserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JGomez
 */
@Service
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public Object save(User user) {
        return userDAO.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
    
    @Override
    public List<User> filter(String name) {
        return userDAO.filter(name);
    }   
    
    @Override
    public long count() {
        return userDAO.count();
    }  

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

}