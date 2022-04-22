package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Professor;

public class professorMapper implements RowMapper<Professor>{

	@Override
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		  Professor professor = new Professor(rowNum, null, null, null);
		  professor.setId(rs.getInt("id"));
		  professor.setName(rs.getString("name"));
		  professor.setEmail(rs.getString("email"));
		  professor.setMobile(rs.getString("mobile"));
		  
	      return professor;
		
	}

}