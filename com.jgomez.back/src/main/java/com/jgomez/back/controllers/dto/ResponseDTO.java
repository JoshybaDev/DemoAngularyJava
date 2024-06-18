/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgomez.back.controllers.dto;

import lombok.*;

/**
 *
 * @author JGomez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO {
    private String status;
    private String msg;
    private int code;
    private String redirect;
}
