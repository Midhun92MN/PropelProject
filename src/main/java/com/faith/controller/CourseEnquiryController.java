package com.faith.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.entity.CourseEnquiry;
import com.faith.entity.Status;
import com.faith.service.ICourseEnquiryService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class CourseEnquiryController {

	@Autowired
	ICourseEnquiryService courseEnquiryService;

	@GetMapping("course-enquiries")
	public List<CourseEnquiry> findAllCourseEnquiries() {
		return courseEnquiryService.findAllCourseEnquiries();
	}

	@GetMapping("status")
	public List<Status> findAllStatus() {
		return courseEnquiryService.findAllStatus();
	}

	@PostMapping("course-enquiries")
	public CourseEnquiry insertCourseEnquiries(CourseEnquiry courseEnquiry) {
		return courseEnquiryService.insertCourseEnquiry(courseEnquiry);
	}
	
	@PutMapping("course-enquiries")
	public CourseEnquiry updateCourseEnquiries(CourseEnquiry courseEnquiry) {
		return courseEnquiryService.updateCourseEnquiry(courseEnquiry);
	}

	@GetMapping("course-enquiries/{id}")
	public Optional<CourseEnquiry> findCourseEnquiryById(@PathVariable int id) {
		return courseEnquiryService.findByEnquiryId(id);
	}

	@GetMapping("course-enquiries/name/{courseEnquiryName}")
	public List<CourseEnquiry> findCourseEnquiryByName(@PathVariable(name = "courseEnquiryName") String name) {
		return courseEnquiryService.findByName(name);
	}

	@GetMapping("course-enquiries/status/{statusId}")
	public List<CourseEnquiry> filterCourseEnquiryByStatus(@PathVariable int statusId) {
		return courseEnquiryService.filterByStatus(statusId);
	}

	@GetMapping("course-enquiries/date/{startDate}&{endDate}")
	List<CourseEnquiry> filterCourseEnquiryByDate(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
		return courseEnquiryService.filterByDate(startDate, endDate);
	}

}
