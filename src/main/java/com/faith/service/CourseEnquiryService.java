package com.faith.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.entity.CourseEnquiry;
import com.faith.entity.Status;
import com.faith.entity.StatusCount;
import com.faith.repo.ICourseEnquiryRepo;
import com.faith.repo.IStatusRepo;

@Service
public class CourseEnquiryService implements ICourseEnquiryService {

	@Autowired
	private ICourseEnquiryRepo courseEnquiryRepo;
	@Autowired
	private IStatusRepo statusRepo;

	@Override
	public List<CourseEnquiry> findAllCourseEnquiries() {
		return (List<CourseEnquiry>) courseEnquiryRepo.findAll();
	}

	@Override
	public List<Status> findAllStatus() {
		return (List<Status>) statusRepo.findAll();
	}

	@Transactional
	@Override
	public CourseEnquiry insertCourseEnquiry(CourseEnquiry courseEnquiry) {
		return courseEnquiryRepo.save(courseEnquiry);
	}

	@Transactional
	@Override
	public CourseEnquiry updateCourseEnquiry(CourseEnquiry courseEnquiry) {
		return courseEnquiryRepo.save(courseEnquiry);
	}

	@Override
	public Optional<CourseEnquiry> findByEnquiryId(int enquiryId) {
		return courseEnquiryRepo.findById(enquiryId);
	}

	@Override
	public List<CourseEnquiry> findByName(String name) {
		return courseEnquiryRepo.findByName(name);
	}

	@Override
	public List<CourseEnquiry> filterByStatus(int statusId) {
		return courseEnquiryRepo.filterByStatusId(statusId);
	}

	@Override
	public List<CourseEnquiry> filterByDate(LocalDate startDate, LocalDate endDate) {
		return courseEnquiryRepo.filterByDate(startDate, endDate);
	}
	
	@Override
	public List<StatusCount> getStatusCount(){
		return courseEnquiryRepo.getStatusCount();
	}
	
	@Override
	public List<StatusCount> getStatusCountBetweenDates(LocalDate startDate,LocalDate endDate){
		return courseEnquiryRepo.getStatusCountBetweenDates(startDate,endDate);
	}

}
