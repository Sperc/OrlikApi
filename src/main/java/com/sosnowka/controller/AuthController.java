package com.sosnowka.controller;

import com.sosnowka.model.AppUser;
import com.sosnowka.model.Player;
import com.sosnowka.model.wraper.ChangePassword;
import com.sosnowka.service.AppUserService;
import com.sosnowka.service.PlayerService;
import org.aspectj.weaver.bcel.BcelAccessForInlineMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Pawel on 03.11.2017.
 */
@RestController
public class AuthController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private UserDetailsService userDetailsService;

    public AuthController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<AppUser> createPlater(@RequestBody AppUser appUser) {

        if (appUserService.findByUsername(appUser.getUsername()) != null) {
            return new ResponseEntity<AppUser>(appUser, HttpStatus.BAD_REQUEST);
        }
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        appUser.setRoles(roles);
//        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return new ResponseEntity<AppUser>(appUserService.save(appUser), HttpStatus.OK);
    }
//
//    @PostMapping("/login")
//    public void signUp(@RequestBody AppUser user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        appUserService.save(user);
//    }

    @PutMapping("/change-password")
    public HttpEntity changePassword(@RequestBody ChangePassword changePassword) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        AppUser appUser1 = appUserService.findByUsername(name);
        if (appUser1 == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if (!bCryptPasswordEncoder.matches(changePassword.getCurrentPassword(), appUser1.getPassword()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        appUser1.setPassword(changePassword.getNewPassword());
        appUserService.save(appUser1);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("delete-account")
    public HttpEntity deleteAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        AppUser appUser1 = appUserService.findByUsername(name);
        Player player = playerService.findOneByUsername(name);
        try {
            playerService.delete(player);
            appUserService.delete(appUser1);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
