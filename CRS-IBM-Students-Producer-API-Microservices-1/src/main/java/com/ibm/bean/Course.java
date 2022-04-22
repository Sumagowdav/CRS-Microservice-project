package com.ibm.bean;


import java.util.List;

public class Course {
	private int sid;
	private int courseId;
	private String courseName;
	private int fees;
	private int seats;
	private String prof;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	//constructor
	public Course( int sid, int courseId, String courseName, int fees, int seats, String prof) {
		super();
		this.sid=sid;
		this.courseId = courseId;
		this.courseName = courseName;
		this.fees = fees;
		this.seats = seats;
		this.prof = prof;
	}

	public Course() {
		super();
	}

	public Course(List<Object> asList) {
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

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}
	
}