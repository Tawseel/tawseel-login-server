package com.example.tawseelserver.controllers;

import com.example.tawseelserver.authantication.jwt.TokensManager;
import com.example.tawseelserver.authantication.UsernameAndPassword;
import com.example.tawseelserver.services.LoginService;
import com.example.tawseelserver.tables.Client;
import com.example.tawseelserver.tables.Store;
import com.example.tawseelserver.tables.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/login")
public class LoginController
{
    @Autowired
    LoginService loginService;

    @Autowired
    TokensManager tokensManager;

    @GetMapping
    public String helloWorld(){
        return "Hello world";
    }

    @PostMapping(path = "/register/store")
    public ResponseEntity<Boolean> signUp(@RequestBody Store store)
    {
        boolean isSignUp =  loginService.signUp(store);
        HttpStatus httpStatus = isSignUp ? HttpStatus.CREATED : HttpStatus.OK;
        return new ResponseEntity<>(isSignUp, httpStatus);
    }

    @PostMapping(path = "/register/client")
    public ResponseEntity<?> signUp(@RequestBody Client client)
    {
        boolean isSignUp =  loginService.signUp(client);
        HttpStatus httpStatus = isSignUp ? HttpStatus.CREATED : HttpStatus.OK;
        return new ResponseEntity<>(isSignUp, httpStatus);
    }

    @PostMapping(path="/signin/{userType}")
    public ResponseEntity<Boolean> signIn(@RequestBody UsernameAndPassword auth, @PathVariable("userType") UserType userType)
    {
        String token = loginService.signIn(auth, userType);
        boolean isLoginSuccessful = token != null;
        return new ResponseEntity<>(isLoginSuccessful, tokensManager.getTokenHeader(token),HttpStatus.OK);
    }

}
