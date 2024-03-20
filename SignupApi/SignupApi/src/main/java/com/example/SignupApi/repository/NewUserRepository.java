package com.example.SignupApi.repository;

import com.example.SignupApi.entity.NewUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewUserRepository extends CrudRepository<NewUser, Integer> {

    public Optional<NewUser> findByUserName(String userName);

}

