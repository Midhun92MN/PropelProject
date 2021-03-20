package com.faith.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.entity.Status;
@Repository
public interface IStatusRepo extends CrudRepository<Status, Integer> {

}
