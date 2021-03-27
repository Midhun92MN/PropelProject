package com.faith.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.entity.CourseEnquiry;
import com.faith.entity.StatusCount;

@Repository
public interface ICourseEnquiryRepo extends CrudRepository<CourseEnquiry, Integer> {

	@Query("from CourseEnquiry where enqDate between ?1 and ?2")
	public List<CourseEnquiry> filterByDate(LocalDate startDate, LocalDate endDate);

	@Query("from CourseEnquiry where status.statusId = ?1")
	public List<CourseEnquiry> filterByStatusId(int statusId);

	@Query("from CourseEnquiry where name like %?1%")
	public List<CourseEnquiry> findByName(String name);

	@Query("select new com.faith.entity.StatusCount(e.status.statusId,count(e)) from CourseEnquiry e group by e.status.statusId")
	public List<StatusCount> getStatusCount();

	@Query("select new com.faith.entity.StatusCount(e.status.statusId,count(e)) from CourseEnquiry e where enqDate between :startDate and :endDate group by e.status.statusId")
	public List<StatusCount> getStatusCountBetweenDates(LocalDate startDate, LocalDate endDate);

}
