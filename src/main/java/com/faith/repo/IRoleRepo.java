package com.faith.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.entity.Role;
@Repository
public interface IRoleRepo extends CrudRepository<Role, Integer> {

}
