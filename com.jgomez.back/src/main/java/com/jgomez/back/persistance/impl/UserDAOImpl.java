/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.persistance.impl;

import com.jgomez.back.entities.User;
import com.jgomez.back.persistance.IUserDAO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.jgomez.back.repository.IUserRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author JGomez
 */
@Component
public class UserDAOImpl implements IUserDAO{
    
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Object save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> filter(String name) {
        return userRepository.filter(name);
    }
    
    
    @Override
    public long count() {
        return userRepository.count();
    }    


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
}
