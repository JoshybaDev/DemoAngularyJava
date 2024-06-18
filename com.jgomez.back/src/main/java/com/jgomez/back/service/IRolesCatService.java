/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgomez.back.service;

import com.jgomez.back.entities.RolesCat;
import java.util.List;

/**
 *
 * @author JGomez
 */
public interface IRolesCatService {
    List<RolesCat> findAll();
    
    void save(RolesCat rol);
}
