package com.example.SignupApi.controller;

import com.example.SignupApi.entity.NewUser;
import com.example.SignupApi.entity.UserDTO;
import com.example.SignupApi.exception.UserNotFoundException;
import com.example.SignupApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping("/alluser")
    public ResponseEntity<List<NewUser>> getAllUser()
    {
        List<NewUser> list = (List<NewUser>) userService.getAll();
        if(list.size() <= 0)
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/newuser/{id}")
    public ResponseEntity<?> getNewUser(@PathVariable("id") int id) {
        try {
            NewUser newUser = userService.getById(id);
            return ResponseEntity.of(Optional.of(newUser));
        }
        catch(UserNotFoundException ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/newuser")
    public ResponseEntity<NewUser> addUser(@RequestBody UserDTO userDTO)
    {
        NewUser user = null ;
        try
        {
            user = this.userService.add(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
