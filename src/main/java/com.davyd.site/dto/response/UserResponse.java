package com.davyd.site.dto.response;


import com.davyd.site.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String username;
    private String password;

    public UserResponse(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
    }
}
