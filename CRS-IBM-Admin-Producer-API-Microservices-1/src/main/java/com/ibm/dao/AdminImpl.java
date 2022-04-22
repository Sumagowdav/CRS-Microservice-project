package com.ibm.dao;

// import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.Admin;
import com.ibm.bean.Professor;
import com.ibm.bean.Student;
import com.ibm.bean.User;
import com.ibm.mapper.AdminMapper;
import com.ibm.mapper.StudentMapper;
import com.ibm.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AdminImpl implements AdminDAO {

    @Autowired
    private JdbcTemplate jdbcTemplateObject;
    
    @Override
    @Transactional
    public List<Admin> list() {
        // List all Admins
        String SQL = "select * from admin";
            List <Admin> admins = jdbcTemplateObject.query(SQL, 
                                    new AdminMapper());
                    
            return admins;
    }

    @Override
    @Transactional
    public Admin create(Admin admin) {
        // create an admin
        String SQL = "insert into admin (name, email, password ) values ( ?, ?, ?)";
		      
        jdbcTemplateObject.update( SQL,new Object[] {admin.getName(),admin.getEmail(),admin.getPassword()});
        System.out.println("Created Record Name = " + admin.getName());
       
        return admin;
    }

    @Override
    @Transactional
    public Admin update(Admin admin) {
        // update admin info

        String SQL = "update admin set password = ? where id = ?";
        jdbcTemplateObject.update(SQL, new Object[]{admin.getName(),admin.getPassword()});
        System.out.println("Updated Record with ID = " + admin.getId() );
        return admin;
    }

    @Override
    public Long delete(Long id) {
        // delete an admin
        String SQL = "delete from admin where id = ?";
		      jdbcTemplateObject.update(SQL, id);
		      System.out.println("Deleted Record with ID = " + id );
		      return 0L;
    }

    @Override
    @Transactional
    public List<Student> listStudents() {
        // list all students
            String SQL = "select * from student";
            List <Student> students = jdbcTemplateObject.query(SQL, 
                                    new StudentMapper());
                    
            return students;
    }

    @Override
    public void deleteStudent(Integer id) {
        // Delete student profile
        String SQL = "delete from student where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
        
    }

    @Override
    @Transactional
    public Professor addProfessor(Professor professor) {
        // Add professor profile
        String SQL = "insert into admin (id, name, email, password ) values (?, ?, ?, ?)";
		      
        jdbcTemplateObject.update( SQL,new Object[] {professor.getId(),professor.getName(),professor.getEmail(),professor.getMobile()});
        System.out.println("Created Record Name = " + professor.getName());
       
        return professor;
    }

    @Override
    public void deleteProfessor(Integer id) {
        // Delete professor profile
        String SQL = "delete from professor where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
        
    }

    @Override
    public User addProfileMain(User user) {
        // Give username and password to a user
        String SQL = "insert into user (id, email, password) values (?, ?, ?)";
        jdbcTemplateObject.update( SQL,new Object[] {user.getId(),user.getEmail(),user.getPassword()});
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        // Get all users username and password
        String SQL = "select * from user";
            List <User> users = jdbcTemplateObject.query(SQL, 
                                    new UserMapper());
                    
            return users;
    }

    

}
    
