package com.launchclub.validation;

public interface StudentValidation {

    boolean validatePhoneNo(final String phoneNumber);

    boolean validateName(final String name);

    boolean validateRollNo(final String rollNo);

    boolean validateStandard(final String standard);

    boolean validateEmailId(final String emailId);

    boolean validateDate(final String date);

    boolean validateChoice(final String choice);

}
