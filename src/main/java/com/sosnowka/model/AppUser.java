package com.sosnowka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Pawel on 01.10.2017.
 */
@Entity
@JsonRootName("user")
public class AppUser implements UserDetails {
    @ManyToMany(mappedBy = "appUserSet")
    private Set<Booking> usersBookingSet;

    @ManyToMany
    @JsonIgnoreProperties("setOfUser")
    private Set<Team> userTeams;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @Column(unique = true)
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private Set<AppUser> friendList;
    @ElementCollection
    private List<String> roles = new ArrayList<>();


    public AppUser() {
    }

    public Set<Team> getUserTeams() {
        return userTeams;
    }

    public Set<AppUser> getFriendList() {
        return friendList;
    }

    public void setFriendList(Set<AppUser> friendList) {
        this.friendList = friendList;
    }

    public void setUserTeams(Set<Team> userTeams) {
        this.userTeams = userTeams;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Set<Booking> getUsersBookingSet() {
        return usersBookingSet;
    }

    public void setUsersBookingSet(Set<Booking> usersBookingSet) {
        this.usersBookingSet = usersBookingSet;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }


}
