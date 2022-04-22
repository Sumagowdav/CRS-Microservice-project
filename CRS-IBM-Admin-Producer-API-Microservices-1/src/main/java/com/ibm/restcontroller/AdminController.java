package com.ibm.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bean.Admin;
import com.ibm.bean.User;
import com.ibm.dao.AdminDAO;


@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminDAO adminDAO;

    @RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET,value = "/admins")
    @ResponseBody
    public List<Admin> getAllAdmins() {
        //list all admins
        return adminDAO.list();
    }

   

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/post/admins")
    @ResponseBody
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        //create new admin
        adminDAO.create(admin);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.PUT, value = "/put/admins/{id}")
    @ResponseBody
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Integer id,@RequestBody Admin admin) {
        //update admin information
        Admin p = adminDAO.update(admin);
        return new ResponseEntity<Admin>(p, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.DELETE, value = "/delete/admins/{id}")
    @ResponseBody
    //delete an admin
    public ResponseEntity<Long> deleteAdmin(@PathVariable Long id) {
       if(null == adminDAO.delete(id)){
            return new ResponseEntity("No Admin found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/user/post/all")
    @ResponseBody
    public ResponseEntity<User> updateUserMain(@RequestBody User user) {
        adminDAO.addProfileMain(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value = "/users/all")
    @ResponseBody
    public List<User> getUserMain() {
        List<User> user = adminDAO.getAllUsers();
        return user;
    }
}