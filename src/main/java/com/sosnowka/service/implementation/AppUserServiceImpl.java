package com.sosnowka.service.implementation;

import com.sosnowka.model.AppUser;
import com.sosnowka.repository.AppUserRepository;
import com.sosnowka.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pawel on 03.11.2017.
 */
@Service
public class AppUserServiceImpl implements AppUserService{
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findOneByUsername(username);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return save(appUser);
    }
}
