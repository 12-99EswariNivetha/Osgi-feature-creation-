package com.theatmo.studentmanagement.controller;

import com.theatmo.studentmanagement.model.Student;

import javax.ws.rs.*;
import java.util.Map;

@Path("/")
public class StudentApiImpl extends StudentController implements StudentRestController {

    @Override
    @Path("/add")
    @Consumes("application/json")
    @POST
    public boolean addStudent(final Student student) {
        return super.addStudent(student);
    }

    @Override
    @Path("/{rollNo}")
    @Produces("application/json")
    @DELETE
    public boolean removeStudent(@PathParam("rollNo")final int rollNo) {
        return super.removeStudent(rollNo);
    }

    @Override
    @Path("/put")
    @Produces("application/json")
    @PUT
    public boolean updateStudentDetails(final Student student) {
        System.out.println("hii");
        return super.updateStudentDetails(student);
    }

    @Override
    @Path("/view")
    @Produces("application/json")
    @GET
    public Map<Integer, Student> getAllStudents() {
        return super.getAllStudents();
    }

    @Override
    @Path("/{rollNo}")
    @Produces("application/json")
    @GET
    public Student searchStudentDetail(@PathParam("rollNo") final int rollNo) {
        return super.searchStudentDetail(rollNo);
    }
    @Override
    @Path("/get")
    @Produces("application/json")
    @GET
    public String getdetail() {
        return "hiiii";
    }
}
