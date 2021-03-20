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

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "moduleId")
@Entity
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int moduleId;
	private String moduleName;

	@JsonIgnore
	@ManyToMany(mappedBy = "modules")
	List<Course> courses;

	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Module(int moduleId, String moduleName, List<Course> courses) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.courses = courses;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
