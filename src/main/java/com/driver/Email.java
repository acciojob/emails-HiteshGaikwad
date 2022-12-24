package com.driver;


public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(getPassword())) {
            boolean isDigitPresent = false;
            boolean isUpperCasePresent = false;
            boolean isLowerCasePresent = false;
            boolean isLengthSufficient = false;
            boolean isSpecialCharPresent = false;
            if (newPassword.length() >= 8) {
                isLengthSufficient = true;
            }
            for (int i = 0; i < newPassword.length(); i++) {
                int ascii = (int) (newPassword.charAt(i));
                if (ascii > 47 && ascii < 58) {
                    isDigitPresent = true;
                } else if (ascii > 64 && ascii < 91) {
                    isUpperCasePresent = true;
                } else if (ascii > 96 && ascii < 123) {
                    isLowerCasePresent = true;
                } else {
                    isSpecialCharPresent = true;
                }
            }
            if (isDigitPresent && isLengthSufficient && isLowerCasePresent
                    && isUpperCasePresent && isSpecialCharPresent) {
                this.password = newPassword;
            }
        }
    }
}

