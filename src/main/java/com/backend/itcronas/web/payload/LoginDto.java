package com.backend.itcronas.web.payload;


import lombok.Data;

@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}