package com.theatmo.studentinputs.studentinputimpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInputs implements StudentInputService{

    private static StudentInputService studentInputs;
    public static final Scanner SCANNER = new Scanner(System.in);

    private StudentInputs(){

    }
    public static StudentInputService getInstance(){

        if(studentInputs == null){
            studentInputs = new StudentInputs();
        }
        return studentInputs;
    }
    public String getString(String content) {
        System.out.println(content);
        try {
            return SCANNER.next().trim();
        } catch (InputMismatchException e) {
            System.out.println("Enter Correct Value");
            return getString(content);
        }
    }
}
