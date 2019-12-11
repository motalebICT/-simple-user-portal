package com.bitmascot.controller;

import com.bitmascot.model.AppUser;
import com.bitmascot.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by motaleb14029 on 12/8/2019.
 */
@Controller
public class AdminPanel {

    @Autowired
    private AppUserRepository appUserRepository;

    @RequestMapping("/admin")
    private String loadAdminPanel(Principal principal, Model model){
        String email= principal.getName();
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        if(appUser.getRole().equals("ADMIN")) {
            model.addAttribute("user_name", appUser.getFirst_name()+" "+appUser.getLast_name());

            Iterable<AppUser> appUserIterable = appUserRepository.findAppUserByRole("USER");
            appUserIterable.forEach((user)->{
                user.setName(user.getFirst_name()+" "+user.getLast_name());
                int year = Integer.parseInt(user.getDob().split("-")[0]);
                int current_year = (new Date().getYear())+1900;
                user.setAge(current_year-year);
            });
            model.addAttribute("user_list", (List<AppUser>) appUserIterable);
            return "admin";
        }else{
            return "error";
        }
    }


}
