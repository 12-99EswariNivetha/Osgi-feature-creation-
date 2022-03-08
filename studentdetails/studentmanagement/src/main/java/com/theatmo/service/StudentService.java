package com.theatmo.service;


import com.theatmo.model.Student;

import java.util.Map;


/**
 * Interface to provide StudentService.
 *
 * @author EswariNivethaVU
 */
public interface StudentService {

    boolean addStudent(final Student student);

    boolean removeStudent(final int rollNo);

    Map<Integer, Student> getAllStudents();

    Student selectStudent(final int rollNo);

    boolean updateStudentDetails(final Student student);
}

