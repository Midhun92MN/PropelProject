package com.faith.entity;

import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "courseId")
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	private String description;
	private int durationDays;
	private double fees;
	private boolean isActive;

	@ManyToMany
	private List<Module> modules;

	@ManyToMany
	private List<Qual> quals;

	@JsonIgnore
	@ManyToMany(mappedBy = "enquiredCourses")
	private List<CourseEnquiry> courseEnquiries;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int courseId, String courseName, String description, int durationDays, double fees, boolean isActive,
			List<Module> modules, List<Qual> quals, List<CourseEnquiry> courseEnquiries) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.durationDays = durationDays;
		this.fees = fees;
		this.isActive = isActive;
		this.modules = modules;
		this.quals = quals;
		this.courseEnquiries = courseEnquiries;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Qual> getQuals() {
		return quals;
	}

	public void setQuals(List<Qual> quals) {
		this.quals = quals;
	}

	public List<CourseEnquiry> getCourseEnquiries() {
		return courseEnquiries;
	}

	public void setCourseEnquiries(List<CourseEnquiry> courseEnquiries) {
		this.courseEnquiries = courseEnquiries;
	}

}
