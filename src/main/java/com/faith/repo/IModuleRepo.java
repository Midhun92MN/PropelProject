package com.faith.repo;

import org.springframework.data.repository.CrudRepository;
import com.faith.entity.Module;


public interface IModuleRepo extends CrudRepository<Module, Integer> {

}
