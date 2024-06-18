/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.persistance.impl;

import com.jgomez.back.entities.RolesCat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jgomez.back.repository.IRolesCatRepository;
import com.jgomez.back.persistance.IRolesCatDAO;

/**
 *
 * @author JGomez
 */
@Component
public class RolesCatDAOImpl implements IRolesCatDAO{

    @Autowired
    private IRolesCatRepository rolRepository;    
    
    @Override
    public List<RolesCat> findAll() {
        return (List<RolesCat>)rolRepository.findAll();
    }

    @Override
    public void save(RolesCat rol) {
        rolRepository.save(rol);
    }
    
}
