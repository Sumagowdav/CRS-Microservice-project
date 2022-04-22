package com.ibm.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bean.Professor;
import com.ibm.bean.RegisteredCourse;

import com.ibm.dao.Professordao;

@RestController
@CrossOrigin
public class ProfessorController {
	
	    @Autowired
	    private Professordao professordao;
	    
	    /** 
	     * register RESTendpoint is used by professor to see list of registered students
	     * @return list of registered students
	     * url:professor/students
	     * description: list all students
	     */

	    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value = "professor/students")
	    @ResponseBody
	    public List<Professor> getAllStudents() {
	        //list all professors
	        return professordao.list();
	    }
	    
	    /** 
	     * register RESTendpoint is used by professor to grade students
	     * @param registeredCourse
	     * @return course that has been graded
	     * url:post/students/grades
	     * description: Grade students
	     */
	    
	    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/post/students/grades")
	    @ResponseBody
	    public ResponseEntity<RegisteredCourse> createProfessor(@RequestBody RegisteredCourse registeredCourse) {
	        //Grade students
	        professordao.grade(registeredCourse);
	        return new ResponseEntity<>(registeredCourse, HttpStatus.OK);
	    }


}
