package com.bitmascot.controller;

import com.bitmascot.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by motaleb14029 on 12/7/2019.
 */
@Controller
public class LoginController {

    @Autowired
    AppUserRepository appUserRepository;

    /* It will return login.html page */
    @GetMapping("/")
    private String loadLoginPage()
    {
        return "login";
    }

}
