package com.example.SignupApi.service;

import com.example.SignupApi.entity.NewUser;
import com.example.SignupApi.entity.Role;
import com.example.SignupApi.entity.UserDTO;
import com.example.SignupApi.repository.NewUserRepository;
import com.example.SignupApi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private NewUserRepository newUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Iterable<NewUser> getAll(){

        List<NewUser> employees = ( List<NewUser>) this.newUserRepository.findAll();
        return employees.stream()
                .filter(NewUser::isActive)
                .collect(Collectors.toList());

    }

    public NewUser getById(int id){
        NewUser newUser = new NewUser();
        newUser = this.newUserRepository.findById(id).orElse(null);
        if(newUser != null)
        {
            if(newUser.isActive())
            {
                return newUser;
            }
        }
        return newUser;
    }

    public NewUser add(UserDTO userDTO){
        NewUser user = new NewUser();
        Role role = roleRepository.findByRoleName(userDTO.getRoleName());
        user.setName(userDTO.getName());
        user.setActive(true);
        user.setRole(role);
        user.setEmail(user.getEmail());
        user.setUserName(userDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        EmailSender.Send(userDTO.getEmail());
        return newUserRepository.save(user);
    }

    public void delete(int id) {
        NewUser newUser = newUserRepository.findById(id).orElse(null);
        if(newUser != null) {
            if(newUser.isActive()) {
                newUser.setActive(false);
            }
        }
    }



}
