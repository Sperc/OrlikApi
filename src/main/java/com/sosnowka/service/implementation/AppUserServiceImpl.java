package com.sosnowka.service.implementation;

import com.sosnowka.model.AppUser;
import com.sosnowka.repository.AppUserRepository;
import com.sosnowka.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Pawel on 03.11.2017.
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findOneByUsername(username);
    }

    @Override
    public AppUser save(AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }
}
