package com.example.SignupApi.jwt;

import com.example.SignupApi.entity.NewUser;
import com.example.SignupApi.repository.NewUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {


    @Autowired
   private NewUserRepository newUserRepositoryRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       NewUser newUser =  newUserRepositoryRepository.findByUserName(username).orElseThrow(() -> new RuntimeException("User not found !!"));

        return new User(
                newUser.getUsername(),
                newUser.getPassword(),
                this.getAuthorities(newUser)
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities(NewUser newUser){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+newUser.getRole().getRoleName()));
        return authorities;
    }
}
