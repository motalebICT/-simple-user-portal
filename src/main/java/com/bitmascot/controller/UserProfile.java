package com.bitmascot.controller;

import com.bitmascot.model.AppUser;
import com.bitmascot.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

/**
 * Created by motaleb14029 on 12/8/2019.
 */
@Controller
public class UserProfile {

    @Autowired
    private AppUserRepository appUserRepository;

    @RequestMapping("/profile")
    private String loadUserProfile(Principal principal, Model model){

        String email = principal.getName();
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        if(appUser.getRole().equals("USER")){
            model.addAttribute("user", appUser);
            return "profile";
        }else{
            return "error";
        }
    }

    @RequestMapping("/change-password")
    private String loadChangePasswordPage(Principal principal, Model model)
    {
        String email = principal.getName();
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        model.addAttribute("user_name", appUser.getFirst_name()+" "+appUser.getLast_name());
        return "change_password";
    }


    @RequestMapping(value = "/change-user-password", method = RequestMethod.POST)
    private String changeUserPassword(Principal principal, @RequestParam String previousPassword,
                                      @RequestParam String newPassword, Model model)
    {
        AppUser appUser = appUserRepository.findAppUserByEmail(principal.getName());
        if(appUser.getPassword().equals(previousPassword)){
            try{
                appUser.setPassword(newPassword);
                appUserRepository.save(appUser);
                model.addAttribute("message","Password successfully changed.");
            }catch (Exception e){
                model.addAttribute("message","Some error occurred, Please try again.");
            }
        }else {
            model.addAttribute("message","");
        }
        model.addAttribute("user_name", appUser.getFirst_name()+" "+appUser.getLast_name());
        return "change_password";
    }


}
