/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgomez.back.repository;

import com.jgomez.back.entities.RolesCat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JGomez
 */
@Repository
public interface IRolesCatRepository extends CrudRepository<RolesCat, Long>{ 
    
}
