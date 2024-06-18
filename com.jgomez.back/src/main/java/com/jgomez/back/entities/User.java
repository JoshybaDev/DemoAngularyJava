/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author JGomez
 */
@Setter
@Getter
@Builder(toBuilder = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    //@JsonIgnore
    private String password;
    @Column(length = 9993922)
    private String iperfil;
    @CreationTimestamp
    private Instant createdOn;
    @UpdateTimestamp
    private Instant lastUpdatedOn;

//    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "user_roles",
            joinColumns = {
                @JoinColumn(name = "user_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "roles_id")})
    private Set<Rol> roles = new HashSet<>();
}
