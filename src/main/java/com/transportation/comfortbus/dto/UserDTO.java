package com.transportation.comfortbus.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    @JsonIgnore
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private UserRole role;

}
