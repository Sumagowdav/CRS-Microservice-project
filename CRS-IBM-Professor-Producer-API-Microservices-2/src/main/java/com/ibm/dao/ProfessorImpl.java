package com.ibm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.Professor;
import com.ibm.bean.RegisteredCourse;
import com.ibm.mapper.professorMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class ProfessorImpl implements Professordao {
    @Autowired
    private JdbcTemplate jdbcTemplateObject;
    public static List<Professor> professors;
    {
        professors = new ArrayList<>();
       professors.add(new Professor(500,"suma","suma@gmail.com","909090"));
        
    }
    @Override
    @Transactional
    public List<Professor> list() {
        // List all professors
        String SQL = "SELECT * FROM professor";
        List<Professor> professors = jdbcTemplateObject.query(SQL, new professorMapper());
        return professors;
    }

    @Override
    @Transactional
    public RegisteredCourse grade(RegisteredCourse registeredCourse) {
        //Assign grade to student's course
        String SQL = "INSERT INTO registerations (studentId, courseId, grade) VALUES (?, ?, ?)";
        jdbcTemplateObject.update(SQL,new Object[] {registeredCourse.getStudentId(), registeredCourse.getCourseId(), registeredCourse.getGrade()});
        return registeredCourse;
    }

	@Override
	public List viewEnrolledStudents(int cid) {
		// TODO Auto-generated method stub
		//String SQL ="SELECT * FROM course where  where course_id = ? and student_id = ?;"
		//jdbcTemplateObject.up
		return null;
		
	}

	@Override
	public boolean addGrades(int sid, int cid, String grade) {
		// TODO Auto-generated method stub
		return false;
	}
    

    

}
    