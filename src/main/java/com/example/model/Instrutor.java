package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instrutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private int instructorId;
	@Column(name = "instructor_name")
	private String instructorName;
	@Column(name = "instructor_rating")
	private int instructorRating;

	public Instrutor() {
		super();
	}

	public Instrutor(String instructorName, int instructorRating) {
		super();
		this.instructorName = instructorName;
		this.instructorRating = instructorRating;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public int getInstructorRating() {
		return instructorRating;
	}

	public void setInstructorRating(int instructorRating) {
		this.instructorRating = instructorRating;
	}

	@Override
	public String toString() {
		return "Instrutor [instructorId=" + instructorId + ", instructorName=" + instructorName + ", instructorRating="
				+ instructorRating + "]";
	}

}
