/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.controllers.dto;


import java.time.Instant;
import java.time.LocalDateTime;
import lombok.*;

/**
 *
 * @author JGomez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {//Data Transfer Object

    private Long id;
    private String name;
    private String username;
    private String passwordA;
    //@JsonIgnore
    private String password;
    //@JsonIgnore
    private String password2;
    private String iperfil;
    private Instant  createdOn;
    private Instant  lastUpdatedOn;
    private String rol;
    private long rolid;
}
