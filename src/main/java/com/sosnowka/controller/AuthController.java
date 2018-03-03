package com.sosnowka.controller;

import com.sosnowka.model.AppUser;
import com.sosnowka.model.Player;
import com.sosnowka.service.AppUserService;
import com.sosnowka.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @PostMapping("/login")
//    public ResponseEntity<Player> login(@RequestBody AppUser appUser,
//                                        HttpServletResponse response) throws IOException {
//        String password = appUser.getPassword();
//        String username = appUser.getUsername();
//        AppUser user = appUserService.findByUsername(username);
//
//        if (user != null && user.getPassword().equals(password)) {
//            TokenAuthenticationService.addAuthentication(response, appUser.getUsername());
//            Player player = playerService.findOneByUsername(username);
//            if(player==null){
////                player = new Player();
//                return new ResponseEntity(HttpStatus.NOT_FOUND);
//            }
//            return new ResponseEntity<Player>(player, HttpStatus.OK);
//        } else {
//            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
//        }
//    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<AppUser> createPlater(@RequestBody AppUser appUser) {

        if (appUserService.findByUsername(appUser.getUsername()) != null) {
            return new ResponseEntity<AppUser>(appUser, HttpStatus.BAD_REQUEST);
        }
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        appUser.setRoles(roles);
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return new ResponseEntity<AppUser>(appUserService.save(appUser), HttpStatus.OK);
    }
//
//    @PostMapping("/login")
//    public void signUp(@RequestBody AppUser user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        appUserService.save(user);
//    }

    @PutMapping("/change-password")
    public HttpEntity changePassword(@RequestBody AppUser appUser) {
        AppUser appUser1 = appUserService.findByUsername(appUser.getUsername());
        if (appUser1 == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        appUser1.setPassword(appUser.getPassword());
        appUserService.save(appUser1);
        return new ResponseEntity(HttpStatus.OK);
    }
//    @PutMapping("/change-email")
//    public HttpEntity changeEmail(@RequestBody AppUser appUser){
//        Optional<AppUser> user1 = Optional.ofNullable(appUser).ifPresent(appUser1 -> );
//    }

}
