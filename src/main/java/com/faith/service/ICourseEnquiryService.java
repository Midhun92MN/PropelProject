package com.faith.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.faith.entity.CourseEnquiry;
import com.faith.entity.Status;

public interface ICourseEnquiryService {

	List<CourseEnquiry> findAllCourseEnquiries();

	List<Status> findAllStatus();

	CourseEnquiry insertCourseEnquiry(CourseEnquiry courseEnquiry);

	CourseEnquiry updateCourseEnquiry(CourseEnquiry courseEnquiry);

	Optional<CourseEnquiry> findByEnquiryId(int enquiryId);

	List<CourseEnquiry> findByName(String name);

	List<CourseEnquiry> filterByStatus(int statusId);

	List<CourseEnquiry> filterByDate(LocalDate startDate, LocalDate endDate);

}