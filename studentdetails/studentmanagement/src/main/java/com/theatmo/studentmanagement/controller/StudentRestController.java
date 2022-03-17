package com.theatmo.studentmanagement.controller;

import com.theatmo.studentmanagement.model.Student;

import javax.ws.rs.*;
import java.util.Map;

public interface StudentRestController {

    @Path("/add")
    @Consumes("application/json")
    @POST
    boolean addStudent( final Student student);

    @Path("/{rollNo}")
    @Produces("application/json")
    @DELETE
    boolean removeStudent(final int rollNo);

    @Path("/put")
    @Produces("application/json")
    @PUT
    boolean updateStudentDetails(final Student student);

    @Path("/view")
    @Produces("application/json")
    @GET
    Map<Integer, Student> getAllStudents();

    @Path("/{rollNo}")
    @Produces("application/json")
    @GET
    Student searchStudentDetail(final int rollNo);

    @Path("/get")
    @Produces("application/json")
    @GET
    String getdetail();
}
