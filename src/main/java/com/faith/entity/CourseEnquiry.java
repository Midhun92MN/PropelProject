package com.faith.entity;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "enquiryId")
@Entity
public class CourseEnquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enquiryId;
	private String name;
	private LocalDate dob;
	private String email;
	private String highestQual;
	private LocalDate enqDate;

	@ManyToOne
	@JoinColumn
	private Status status;
	
	@ManyToMany(mappedBy = "courseEnquiries")
	private List<Course> enquiredCourses;

	public CourseEnquiry() {
		super();
	}

	

	public int getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHighestQual() {
		return highestQual;
	}

	public void setHighestQual(String highestQual) {
		this.highestQual = highestQual;
	}

	public LocalDate getEnqDate() {
		return enqDate;
	}

	public void setEnqDate(LocalDate enqDate) {
		this.enqDate = enqDate;
	}

	@JsonManagedReference
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}



	public CourseEnquiry(int enquiryId, String name, LocalDate dob, String email, String highestQual, LocalDate enqDate,
			Status status, List<Course> enquiredCourses) {
		super();
		this.enquiryId = enquiryId;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.highestQual = highestQual;
		this.enqDate = enqDate;
		this.status = status;
		this.enquiredCourses = enquiredCourses;
	}



	public List<Course> getEnquiredCourses() {
		return enquiredCourses;
	}



	public void setEnquiredCourses(List<Course> enquiredCourses) {
		this.enquiredCourses = enquiredCourses;
	}
}
