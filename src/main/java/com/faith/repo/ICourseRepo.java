package com.faith.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.entity.Course;

@Repository
public interface ICourseRepo extends CrudRepository<Course, Integer> {
	
	@Query("from Course where courseName like %?1%")
	public List<Course> findByName(String courseName);

	@Modifying
	@Query("update Course c set c.isActive=false where c.courseId=:courseId")
	public void disableById(int courseId);
	
	@Modifying
	@Query("update Course c set c.isActive=true where c.courseId=:courseId")
	public void enableById(int courseId);

	
	@Query("from Course where isActive=true")
	public List<Course> findAllActiveCourses();
}
