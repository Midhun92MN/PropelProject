package com.faith.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.entity.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer> {
	
	@Query("from Course where courseName like %?1%")
	public List<Course> findByName(String courseName);

	@Query("update Course set isActive=false where courseId=?1")
	public void disableById(int courseId);
	
	@Query("update Course set isActive=true where courseId=?1")
	public void enableById(int courseId);
}
