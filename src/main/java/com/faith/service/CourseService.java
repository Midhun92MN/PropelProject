package com.faith.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.entity.Course;
import com.faith.entity.Qual;
import com.faith.entity.Module;
import com.faith.repo.ICourseRepo;
import com.faith.repo.IModuleRepo;
import com.faith.repo.IQualRepo;

@Service
public class CourseService implements ICourseService {

	@Autowired
	private ICourseRepo courseRepo;
	@Autowired
	private IQualRepo qualRepo;
	@Autowired
	private IModuleRepo moduleRepo;

	@Override
	public List<Course> findAllCourses() {
		return (List<Course>) courseRepo.findAll();
	}

	@Override
	public List<Qual> findAllQuals() {
		return (List<Qual>) qualRepo.findAll();
	}

	@Override
	public List<Module> findAllModules() {
		return (List<Module>) moduleRepo.findAll();
	}

	@Transactional
	@Override
	public Course insertCourse(Course course) {
		return courseRepo.save(course);
	}

	@Transactional
	@Override
	public Course updateCourse(Course course) {
		return courseRepo.save(course);
	}

	@Transactional
	@Override
	public void disableCourseById(int courseId) {
		courseRepo.disableById(courseId);
	}

	@Transactional
	@Override
	public void enableCourseById(int courseId) {
		courseRepo.enableById(courseId);
	}

	@Override
	public Optional<Course> findCourseById(int id) {
		return courseRepo.findById(id);
	}

	@Override
	public List<Course> findCourseByName(String courseName) {
		return courseRepo.findByName(courseName);
	}

}
