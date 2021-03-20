package com.faith.repo;

import org.springframework.data.repository.CrudRepository;

import com.faith.entity.Status;

public interface IStatusRepo extends CrudRepository<Status, Integer> {

}
