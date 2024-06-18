/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.service.impl;

import com.jgomez.back.entities.Rol;
import com.jgomez.back.persistance.IRolDAO;
import com.jgomez.back.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JGomez
 */
@Service
public class RolServiceImpl implements IRolService{

    @Autowired
    private IRolDAO rolDAO;    
    
    @Override
    public Object save(Rol rol) {
        return rolDAO.save(rol);
    }
    
}
