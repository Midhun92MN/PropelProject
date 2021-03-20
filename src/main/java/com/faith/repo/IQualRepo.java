package com.faith.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.entity.Qual;

@Repository
public interface IQualRepo extends CrudRepository<Qual, Integer> {

}
