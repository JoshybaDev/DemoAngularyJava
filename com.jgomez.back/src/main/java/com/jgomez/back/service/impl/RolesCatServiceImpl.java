/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.service.impl;

import com.jgomez.back.entities.RolesCat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jgomez.back.service.IRolesCatService;
import com.jgomez.back.persistance.IRolesCatDAO;

/**
 *
 * @author JGomez
 */
@Service
public class RolesCatServiceImpl implements IRolesCatService {

    @Autowired
    private IRolesCatDAO rolDAO;

    @Override
    public List<RolesCat> findAll() {
        return (List<RolesCat>) rolDAO.findAll();
    }

    @Override
    public void save(RolesCat rol) {
        rolDAO.save(rol);
    }
}
