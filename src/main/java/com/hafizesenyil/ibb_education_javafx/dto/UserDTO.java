package com.hafizesenyil.ibb_education_javafx.dto;

import lombok.*;

// Lombok
@Getter
@Setter
@AllArgsConstructor // Parametreli Constructor
@NoArgsConstructor  // Parametresiz Constructor
@ToString
@Builder

// UserDTO
public class UserDTO {
    // Field
    private Integer id;
    private String username;
    private String password;
    private String email;

    // Parametresiz Constructor
    // Parametreli Constructor
    // Getter And Setter
    // Method


     public static void main(String[] args) {
         UserDTO userDTO= UserDTO.builder()
                 .id(0)
                 .username("username")
                 .email("hfz.snyl@gmail.com")
                 .password("root")
                 .build();

         System.out.println(userDTO);
     }



} //end Class
