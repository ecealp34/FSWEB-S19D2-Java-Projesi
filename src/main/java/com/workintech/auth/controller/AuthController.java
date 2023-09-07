package com.workintech.auth.controller;

import com.workintech.auth.dto.RegistrationMember;
import com.workintech.auth.entity.Member;
import com.workintech.auth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationService authenticationService;
    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/register")
    public Member register(@RequestBody RegistrationMember registrationMember) {
        return authenticationService.register(registrationMember.getEmail(),
        registrationMember.getPassword());
    }
}
