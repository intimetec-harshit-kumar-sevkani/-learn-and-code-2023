package com.example.SignupApi.repository;

import com.example.SignupApi.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {

    public Role findByRoleName(String roleName);

}
