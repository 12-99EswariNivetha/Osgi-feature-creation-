package com.theatmo.view;


import com.theatmo.controller.StudentController;
import com.theatmo.exception.CustomException;
import com.theatmo.model.Student;
import com.theatmo.studentinputs.StudentInputs;
import com.theatmo.studentvalidation.CommonValidation;

import java.sql.Date;
import java.util.Map.Entry;
import java.util.Scanner;



/**
 * Student, View! The StudentView program implements an application that simply
 * displays "User input".
 */
public class StudentView {


    private static final Scanner SCANNER = new Scanner(System.in);
    private static final CommonValidation VALIDATOR = new CommonValidation();
    private static final StudentController STUDENT_CONTROLLER = new StudentController();
    private static final StudentView STUDENT_VIEW = new StudentView();
    private static final StudentInputs STUDENT_INPUTS = new StudentInputs();


    /**
     * Get rollno from the user.
     */
    public  int getRollNo() {
        final int rollNo = STUDENT_INPUTS.getInt("Enter the RollNo(Give 3 Digit No): \n Press @ To Exit to Main Menu");
        StudentView.backToMain(Integer.toString(rollNo));

        if (Validation.validateRollNo(Integer.toString(rollNo))) {
            return Integer.parseInt(Integer.toString(rollNo));
        } else {
            System.out.println("InValid RollNo Please Enter a valid RollNo \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getRollNo();
        }
    }

    /**
     * Get the name from the user.
     */
    public  String getName() {
        final String name = STUDENT_INPUTS.getString("Enter the Name:");
        StudentView.backToMain(name);

        if (VALIDATOR.validateName(name)) {
            return name;
        } else {
            System.out.println(" InValid Name Please Enter a valid Name \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getName();
        }
    }

    /**
     * Get standard from the user.
     */
    public  String getStandard() {
        final String standard = STUDENT_INPUTS.getString("Enter the Standard [PREKG - UKG, 1-12]");
        StudentView.backToMain(standard);

        if (Validation.validateStandard(standard)) {
            return standard;
        } else {
            System.out.println(" InValid Standard Please Enter a valid Standard  \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getStandard();
        }
    }

    /**
     * Get phone no from the user.
     */
    public  long getPhoneNo() {
        final Long phoneNo = STUDENT_INPUTS.getLong("Enter the PhoneNumber:");
        StudentView.backToMain(Long.toString(phoneNo));

        if (VALIDATOR.validatePhoneNo(Long.toString(phoneNo))) {
            return Long.parseLong(Long.toString(phoneNo));
        } else {
            System.out.println(" InValid PhoneNo Please Enter a valid PhoneNo \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getPhoneNo();
        }
    }

    /**
     * Get emailid from the user.
     */
    public  String getEmailId() {
        final String emailId = STUDENT_INPUTS.getString("Enter the EmailId:");
        StudentView.backToMain(emailId);

        if (VALIDATOR.validateEmailId(emailId)) {
            return emailId;
        } else {
            System.out.println("InValid EmailId Please Enter a valid MailId  \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getEmailId();
        }
    }

    /**
     * Get a date from the user.
     */
    public Date getDate() {
        final String date = STUDENT_INPUTS.getString("Enter Date of Joining(yyyy-mm-dd):");
        StudentView.backToMain(date);
        boolean isValid = false;

        try {
            isValid = VALIDATOR.validateDate(date);
        } catch (CustomException e) {
            System.out.println(e);
        }

        if (isValid) {
            return Date.valueOf(date);
        } else {
            System.out.println("InValid Date Please Enter a valid Date \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getDate();
        }
    }

    /**
     * AddStudent by getting values from view and sending a request to the
     * controller.
     */
    public static void addStudent() {
        final int rollNo = STUDENT_VIEW.getRollNo();

        try {
            STUDENT_CONTROLLER.checkRollno(rollNo);
        } catch (CustomException e) {
            System.out.println(e);
            StudentView.addStudent();
            StudentManagement.selectChoice();
        }
        final String name = STUDENT_VIEW.getName();
        final String standard = STUDENT_VIEW.getStandard();
        final long phoneNo = STUDENT_VIEW.getPhoneNo();
        final String emailId = STUDENT_VIEW.getEmailId();
        final Date Date = STUDENT_VIEW.getDate();

        final Student student = new Student(rollNo, name, standard, phoneNo, emailId, Date);

        try {

            if (STUDENT_CONTROLLER.addStudent(rollNo, student)) {
                System.out.println("Inserted SuccessFully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * Display all Students and send a request to the controller.
     */
    public static void showAllStudents() {

        try {
            for (Entry<Integer, Student> entry : STUDENT_CONTROLLER.getAllStudents().entrySet()) {
                System.out.println(entry.getValue());
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * RemoveStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void removeStudent() {

        try {

            if (STUDENT_CONTROLLER.removeStudent(STUDENT_VIEW.getRollNo())) {
                System.out.println("Deleted SuccessFully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * GetStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void selectStudent() {

        try {
            System.out.println(STUDENT_CONTROLLER.searchStudentDetail(STUDENT_VIEW.getRollNo()));
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * UpdateStudents detail.
     */
    public static void updateStudent() {
        final String name = "name";
        final String standard = "standard";
        final String phoneNo = "phoneNo";
        final String emailid = "emailId";
        final String date = "date";
        final Student student = new Student();
        final int rollNo = STUDENT_VIEW.getRollNo();

        try {
            STUDENT_CONTROLLER.checkRollnoForUpdate(rollNo);
        } catch (CustomException e) {
            System.out.println(e);
            StudentView.updateStudent();
            StudentManagement.selectChoice();
        }
        student.setRollNo(rollNo);
        System.out.println("Do you want to change your name? yes or no \n Press @ To Exit to Main Menu ");
        StudentView.updateDetail(student, name);
        System.out.println("Do you want to change your standard? yes or no \n Press @ To Exit to Main Menu ");
        StudentView.updateDetail(student, standard);
        System.out.println("Do you want to change your phoneno? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, phoneNo);
        System.out.println("Do you want to change your email? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, emailid);
        System.out.println("Do you want to change your joiningdate? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, date);

        try {
            if (STUDENT_CONTROLLER.updateStudentDetails(rollNo, student)) {
                System.out.println("Updated Successfully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * Checking next field for update.
     *
     * @param student
     * @param studentdetail
     * @return
     */
    public static Student updateDetail(final Student student, final String studentdetail) {
        final String choiceYes = "yes";
        final String choiceNo = "no";

        while (true) {
            final String option = SCANNER.next().trim();
            StudentView.backToMain(option);

            if (choiceYes.equalsIgnoreCase(option)) {

                if ("name".equalsIgnoreCase(studentdetail)) {
                    student.setName(STUDENT_VIEW.getName());
                    break;
                } else if ("standard".equalsIgnoreCase(studentdetail)) {
                    student.setStandard(STUDENT_VIEW.getStandard());
                    break;
                } else if ("phoneno".equalsIgnoreCase(studentdetail)) {
                    student.setPhonenumber(STUDENT_VIEW.getPhoneNo());
                    break;
                } else if ("emailId".equalsIgnoreCase(studentdetail)) {
                    student.setEmailId(STUDENT_VIEW.getEmailId());
                    break;
                } else if ("date".equalsIgnoreCase(studentdetail)) {
                    student.setDate(STUDENT_VIEW.getDate());
                    break;
                }
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                System.out.println("Invalid Option");
                continue;
            }
        }
        return student;
    }

    /**
     * Getting choice from the user.
     */
    public static String getChoice() {
        final String choice = StudentManagement.SCANNER.next().trim();

        if (Validation.validateChoice(choice)) {
            return choice;
        } else {
            System.out.println("Please Enter Valid Choice use only [1-6]");
            return StudentView.getChoice();
        }
    }

    /**
     * Back to main menu.
     */
    public static void backToMain(String option) {

        if ("@".equals(option)) {
            StudentManagement.selectChoice();
        }
    }
}