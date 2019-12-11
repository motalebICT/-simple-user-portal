package com.bitmascot.controller;

import com.bitmascot.model.AppUser;
import com.bitmascot.repository.AppUserRepository;
import org.springframework.beans. factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by motaleb14029 on 12/8/2019.
 */
@Controller
public class RegistrationController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/registration")
    private String loadRegistrationPage()
    {
        return "registration";
    }

    /* Return boolean value */
    @ResponseBody
    @PostMapping("/check-email")
    private boolean isEmailExist(@RequestParam("email_address") String email) {
        System.out.println("# Check Email : "+email);
        return appUserRepository.existsByEmail(email);
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(@ModelAttribute AppUser appuser, Model model)
    {
        boolean isRegistrationComplete = true;
        System.out.println("# App User : "+appuser.toString());
        try{
            appuser.setRole("USER");
            appUserRepository.save(appuser);
        }catch (Exception e){
            isRegistrationComplete = false;
            e.printStackTrace();
        }

        model.addAttribute("registration_status",isRegistrationComplete);

        return "registration";
    }

}
