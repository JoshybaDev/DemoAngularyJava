/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.persistance.impl;

import com.jgomez.back.entities.Rol;
import com.jgomez.back.persistance.IRolDAO;
import com.jgomez.back.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author JGomez
 */
@Component
public class RolDAOImpl implements IRolDAO{

    @Autowired
    private IRolRepository rolRepository;        
    
    @Override
    public Object save(Rol rol) {
        return rolRepository.save(rol);
    }
    
}
