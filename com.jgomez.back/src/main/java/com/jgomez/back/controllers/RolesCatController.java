/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.controllers;

import com.jgomez.back.controllers.dto.RolesCatDTO;
import com.jgomez.back.entities.User;
import com.jgomez.back.entities.Rol;
import com.jgomez.back.service.IUserService;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jgomez.back.service.IRolesCatService;

/**
 *
 * @author JGomez
 */
@RestController
@RequestMapping("/api/v1/roles")
public class RolesCatController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRolesCatService rolService;

    @GetMapping("/finduserbyid/{id}")
    public ResponseEntity<?> rolesbyUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        Set<Rol> rolesList = new HashSet<>();
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            rolesList = user.getRoles();
        }
        return ResponseEntity.ok(rolesList);
    }

    @GetMapping
    public ResponseEntity<?> roles() {
        List<RolesCatDTO> rolList = rolService.findAll()
                .stream()
                .map(rol -> RolesCatDTO.builder()
                .id(rol.getId())
                .name(rol.getName())
                .build()).toList();
        return ResponseEntity.ok(rolList);
    }
}
