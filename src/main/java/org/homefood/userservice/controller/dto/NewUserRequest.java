package org.homefood.userservice.controller.dto;

import lombok.Data;
import org.homefood.userservice.model.PersonRole;

@Data
public class NewUserRequest {

    private String username;
    private String password;
    private String email;
    private PersonRole role;

}
