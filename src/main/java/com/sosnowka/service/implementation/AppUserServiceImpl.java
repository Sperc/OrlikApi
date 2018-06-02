package com.sosnowka.service.implementation;

import com.sosnowka.exeption.ExceptionMessage;
import com.sosnowka.exeption.NotFoundException;
import com.sosnowka.model.AppUser;
import com.sosnowka.model.Player;
import com.sosnowka.repository.AppUserRepository;
import com.sosnowka.repository.PlayerRepository;
import com.sosnowka.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Pawel on 03.11.2017.
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findOneByUsername(username);
    }

    @Override
    public AppUser save(AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public void delete(String name) throws NotFoundException {
        Optional<AppUser> appUser = Optional.ofNullable(appUserRepository.findOneByUsername(name));
        Optional<Player> player = Optional.ofNullable(playerRepository.findOneByUsername(name));
        if (player.isPresent())
            playerRepository.delete(player.get());

        if (!appUser.isPresent())
            throw new NotFoundException(ExceptionMessage.userNotFound);
        appUserRepository.delete(appUser.get());
    }


}
