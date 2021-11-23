package com.springboot.jcmarket.web.dto.auth;

import lombok.Data;

@Data
public class SignInDto {
    private String user_id;
    private String user_password;
}
