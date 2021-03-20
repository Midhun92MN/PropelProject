package com.faith.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.entity.CourseEnquiry;

@Repository
public interface ICourseEnquiryRepo extends CrudRepository<CourseEnquiry, Integer>{
	
	@Query("from CourseEnquiry where enqDate between ?1 and ?2")
	public List<CourseEnquiry> filterByDate(LocalDate startDate,LocalDate endDate);
	
	@Query("from CourseEnquiry where status.statusId = ?1")
	public List<CourseEnquiry> filterByStatusId(int statusId);
	
	@Query("from CourseEnquiry where name like %?1%")
	public List<CourseEnquiry> findByName(String name);
}
