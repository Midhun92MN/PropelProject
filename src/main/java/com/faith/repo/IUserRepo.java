package com.faith.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.faith.entity.User;
@Repository
public interface IUserRepo extends JpaRepositoryImplementation<User, Integer> {
	
	@Query("from User where userName=?1 and password=?2 and isActive=true")
	public User findByUsernameAndPassword(String fullname, String password);
	
	@Query("from User where fullName like %?1%")
	public List<User> findByName(String userName);
	
	@Modifying
	@Query("update User u set u.isActive=false where u.userId=?1")
	public void disableById(int userId);
	
	@Modifying
	@Query("update User u set u.isActive=true where u.userId=?1")
	public void enableById(int userId);
}
