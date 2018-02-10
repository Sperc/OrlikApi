package com.sosnowka.security;

import com.sosnowka.model.AppUser;
import com.sosnowka.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

/**
 * Created by Pawel on 09.02.2018.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AppUser applicationUser = appUserRepository.findOneByUsername(s);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(s);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }

}
