/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgomez.back.persistance;

import com.jgomez.back.entities.RolesCat;
import java.util.List;

/**
 *
 * @author JGomez
 */
public interface IRolesCatDAO {

    List<RolesCat> findAll();
    
    void save(RolesCat rol);
}
