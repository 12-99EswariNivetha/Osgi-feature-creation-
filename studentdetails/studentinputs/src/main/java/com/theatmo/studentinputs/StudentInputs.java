package com.theatmo.studentinputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInputs {

    public final Scanner SCANNER = new Scanner(System.in);

    public String getString(String content) {
        System.out.println(content);
        return SCANNER.next().trim();
    }

    public long getLong(String content) {
        System.out.println(content);
        try {
            return SCANNER.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("Enter Correct Value");
            return getLong(content);
        }
    }

    public int getInt(String content) {
        System.out.println(content);
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter Correct Value");
            return getInt(content);
        }
    }

}
