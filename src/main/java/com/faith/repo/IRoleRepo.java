package com.faith.repo;

import org.springframework.data.repository.CrudRepository;

import com.faith.entity.Role;

public interface IRoleRepo extends CrudRepository<Role, Integer> {

}
