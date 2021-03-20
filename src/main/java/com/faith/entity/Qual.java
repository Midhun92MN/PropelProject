package com.faith.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "qualId")
@Entity
public class Qual {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qualId;
	private String qualName;

	@JsonIgnore
	@ManyToMany(mappedBy = "quals")
	private List<Course> courses;

	public Qual() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Qual(int qualId, String qualName, List<Course> courses) {
		super();
		this.qualId = qualId;
		this.qualName = qualName;
		this.courses = courses;
	}

	public int getQualId() {
		return qualId;
	}

	public void setQualId(int qualId) {
		this.qualId = qualId;
	}

	public String getQualName() {
		return qualName;
	}

	public void setQualName(String qualName) {
		this.qualName = qualName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
