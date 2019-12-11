package com.bitmascot.securityconfiguration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Predicate;

/**
 * Created by motaleb14029 on 12/8/2019.
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
       // System.out.println("# Credential : "+ authentication.getCredentials().toString());
        System.out.println("# Name : "+ authentication.getName());

       if(authentication.getAuthorities().stream().anyMatch((p)->p.getAuthority().equals("USER"))){
           redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/profile");
       }else{
           redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/admin");
       }

    }
}
