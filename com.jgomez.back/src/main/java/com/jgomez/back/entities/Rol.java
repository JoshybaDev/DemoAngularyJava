/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.*;


/**
 *
 * @author JGomez
 * */
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;    
    //No tiene caso aplicar estas opciones
    //Si se hace al consulta se desborda al ser muchos a muchos
//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
//    private Set<User> users = new HashSet<>();
}
