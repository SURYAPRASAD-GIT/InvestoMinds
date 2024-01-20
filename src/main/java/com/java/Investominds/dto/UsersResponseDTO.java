package com.java.Investominds.dto;

import com.java.Investominds.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponseDTO {
    private String id;
    private String firstName;

    private String lastName;

    private String email;

    private String loginid;

    private String password;

    private Role Role;
}
