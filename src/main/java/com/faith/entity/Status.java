package com.faith.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "statusId")
@Entity
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusId;
	private String statusName;

	@OneToMany(mappedBy = "status")
	@JsonIgnore
	List<CourseEnquiry> courseEnquiries;

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(int statusId, String statusName, List<CourseEnquiry> courseEnquiries) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
		this.courseEnquiries = courseEnquiries;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<CourseEnquiry> getCourseEnquiries() {
		return courseEnquiries;
	}

	public void setCourseEnquiries(List<CourseEnquiry> courseEnquiries) {
		this.courseEnquiries = courseEnquiries;
	}
}
