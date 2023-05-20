package com.security.rest.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/user1")
    @RolesAllowed("admin")
    public String testing1(){
        return "success for user1";
    }

    @RolesAllowed("super_admin")
    @GetMapping("/user2")
    public String testing2(){
        return "success for user2";
    }

    @GetMapping("/user3")
    public String testing3(){
        return "success for user3";
    }
}
