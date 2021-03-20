package com.faith.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faith.entity.Course;
import com.faith.entity.Module;
import com.faith.entity.Qual;
import com.faith.service.ICourseService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class CourseController {
	
	@Autowired
	ICourseService courseService;
	
	
	@GetMapping("courses")
	public List<Course> findAllCourses(){
		return courseService.findAllCourses();
	}
	
	@GetMapping("modules")
	public List<Module> findAllModules(){
		return courseService.findAllModules();
	}
	
	@GetMapping("quals")
	public List<Qual> findAllQuals(){
		return courseService.findAllQuals();
	}
	
	@GetMapping("courses/name/{courseName}")
	public List<Course> findCourseByName(@PathVariable String courseName){
		return courseService.findCourseByName(courseName);
	}
	
	@GetMapping("courses/{courseId}")
	public Optional<Course> findCourseById(@PathVariable int courseId){
		return courseService.findCourseById(courseId);
	}
	
	@PostMapping("courses")
	public void insertCourse(@RequestBody Course course) {
		courseService.insertCourse(course);
	}
	
	@PutMapping("courses")
	public void updateCourse(@RequestBody Course course) {
		courseService.updateCourse(course);
	}
	
	
	
	

}
