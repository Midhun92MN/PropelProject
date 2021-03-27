package com.faith.service;

import java.util.List;
import java.util.Optional;

import com.faith.entity.Course;
import com.faith.entity.Module;
import com.faith.entity.Qual;

public interface ICourseService {

	List<Course> findAllCourses();
	
	List<Course> findAllActiveCourses();

	List<Qual> findAllQuals();

	List<Module> findAllModules();

	Course insertCourse(Course course);

	Course updateCourse(Course course);

	void disableCourseById(int courseId);

	void enableCourseById(int courseId);

	Optional<Course> findCourseById(int id);

	List<Course> findCourseByName(String courseName);

}