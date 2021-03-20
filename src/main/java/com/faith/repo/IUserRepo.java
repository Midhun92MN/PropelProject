package com.faith.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;

import com.faith.entity.User;

public interface IUserRepo extends JpaRepositoryImplementation<User, Integer> {
	
	@Query("from User where userName=?1 and password=?2")
	public User findByUsernameAndPassword(String fullname, String password);
	
	@Query("from User where fullName like %?1%")
	public List<User> findByName(String userName);
	
	@Query("update User set isActive=false where userId=?1")
	public void disableById(int userId);
	
	@Query("update User set isActive=true where userId=?1")
	public void enableById(int userId);
}
