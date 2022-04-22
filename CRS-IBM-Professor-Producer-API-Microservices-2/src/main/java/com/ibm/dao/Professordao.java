package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Professor;
import com.ibm.bean.RegisteredCourse;
import com.ibm.bean.Student;

public interface Professordao {
	public List viewEnrolledStudents(int cid);
	public boolean addGrades(int sid,int cid, String grade);
     public List<Professor> list() ;
    public RegisteredCourse grade(RegisteredCourse registeredCourse);
 
}  
