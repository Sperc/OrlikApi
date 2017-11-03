package com.sosnowka.controller;

import com.sosnowka.model.AppUser;
import com.sosnowka.security.TokenAuthenticationService;
import com.sosnowka.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 03.11.2017.
 */
@RestController
public class AuthController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/login")
    public ResponseEntity<AppUser> login(@RequestBody AppUser appUser,
                                         HttpServletResponse response) throws IOException {
        String password = appUser.getPassword();
        String username = appUser.getUsername();
        AppUser user = appUserService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            TokenAuthenticationService.addAuthentication(response, appUser.getUsername());
            return new ResponseEntity<AppUser>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<AppUser>(HttpStatus.UNAUTHORIZED);
        }
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
        if (appUserService.findByUsername(appUser.getUsername()) != null) {
            new ResponseEntity<AppUser>(appUser,HttpStatus.BAD_REQUEST);
        }
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        appUser.setRoles(roles);
        return new ResponseEntity<AppUser>(appUserService.save(appUser), HttpStatus.CREATED);
    }

}
