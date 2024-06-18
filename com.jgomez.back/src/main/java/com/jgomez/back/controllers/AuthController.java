/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.controllers;

import com.jgomez.back.controllers.dto.AuthRequestDTO;
import com.jgomez.back.controllers.dto.JwtResponseDTO;
import com.jgomez.back.controllers.dto.ResponseDTO;
import com.jgomez.back.entities.Rol;
import com.jgomez.back.entities.User;
import com.jgomez.back.security.JwtService;
import com.jgomez.back.service.IUserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author JGomez
 */
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    JwtService jwtService;
    

    @Autowired
    IUserService userService;    

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
            if (authentication.isAuthenticated()) {

                User user = userService.findByUsername(authRequestDTO.getUsername());

                return ResponseEntity.ok(JwtResponseDTO.builder()
                        .accessToken(jwtService.GenerateToken(authRequestDTO.getUsername()))
                        .msg("Datos correctos")
                        .code(200)
                        .status("ok")
                        .redirect("dashboard/users")
                        .rol((new ArrayList<Rol>(user.getRoles())).get(0).getName())
                        .name(user.getName())
                        .iperfil(user.getIperfil())
                        .build());
            } else {
                throw new UsernameNotFoundException("invalid user request..!!");
            }
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseDTO.builder()
                    .msg("Usuario o contraseña incorrecta")
                    .code(403)
                    .status("error").build());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/ping")
    public String test() {
        try {
            return "Welcome";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
