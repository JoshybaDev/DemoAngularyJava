/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgomez.back.repository;

import com.jgomez.back.entities.Rol;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JGomez
 */
public interface IRolRepository  extends CrudRepository<Rol, Long>{
    
}
