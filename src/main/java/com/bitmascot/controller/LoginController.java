package com.bitmascot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by motaleb14029 on 12/7/2019.
 */
@Controller
public class LoginController {


    @GetMapping("/admin/login")
    private String loadLoginPage()
    {
        return "login";
        //sdkbaskdbaksdha
    }

}
