package com.faith.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.entity.Module;

@Repository
public interface IModuleRepo extends CrudRepository<Module, Integer> {

}
