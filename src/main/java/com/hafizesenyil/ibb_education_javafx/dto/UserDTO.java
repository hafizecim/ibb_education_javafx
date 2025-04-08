package com.hafizesenyil.ibb_education_javafx.dto;

import com.hafizesenyil.ibb_education_javafx.utils.ERole;
import lombok.*;

// Lombok
@Getter
@Setter
//@AllArgsConstructor // Parametreli Constructor
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
    private ERole role;

    // Parametresiz Constructor
    // Parametreli Constructor

    public UserDTO(Integer id, String username, String password, String email, ERole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    // Getter And Setter
    // Method

/*
     public static void main(String[] args) {
         UserDTO userDTO= UserDTO.builder()
                 .id(0)
                 .username("username")
                 .email("hfz.snyl@gmail.com")
                 .password("root")
                 .build();

         System.out.println(userDTO);
     }

*/

} //end Class
