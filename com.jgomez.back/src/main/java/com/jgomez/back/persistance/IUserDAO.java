/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.persistance;

import com.jgomez.back.entities.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGomez
 */
public interface IUserDAO {

    List<User> findAll();

    Optional<User> findById(Long id);

    Object save(User user);

    void deleteById(Long id); 
    
    List<User> filter(String name);
    
    long count();
    
    public User findByUsername(String username);
    
}
