package com.codecool.apigateway.security;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DataValidatorService {

    private final Pattern specialCharacters = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    private final Pattern upperCaseLetters = Pattern.compile("[A-Z ]");
    private final Pattern lowerCaseLetters = Pattern.compile("[a-z ]");
    private final Pattern digitsPattern = Pattern.compile("[0-9 ]");

    private final String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

    public boolean isValidUsername(String username) {
        boolean valid = true;
        if (username.length() < 6) {
            valid = false;
        }
        if (username.contains(" ")) {
            valid = false;
        }
        return valid;
    }

    public boolean isValidPassword(String password) {
        boolean valid = true;
        if (password.length() < 8) {
            valid = false;
        }
//        if (!specialCharacters.matcher(password).find()) {
//            valid = false;
//        }
//        if (!upperCaseLetters.matcher(password).find()) {
//            valid = false;
//        }
//        if (!lowerCaseLetters.matcher(password).find()) {
//            valid = false;
//        }
//        if (!digitsPattern.matcher(password).find()) {
//            valid = false;
//        }
        if (password.contains(" ")) {
            valid = false;
        }
        return valid;
    }

    public boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher isMatch = pattern.matcher(email);
        return isMatch.matches();
    }

}
