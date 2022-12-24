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

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String oldPassword, String newPassword){
        if(oldPassword==this.password){
            if(checkPassword(newPassword)) {
                setPassword(newPassword);
            }
        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
    public boolean checkPassword(String newPassword){
        if(newPassword.length()<8){
            System.out.println("Length of the Password is less than 8");
            return false;
        }
        if(!checkUpperCase(newPassword)){
            System.out.println("Password must contains at least one upper case letter");
            return false;
        }
        if(!checkLowerCase(newPassword)){
            System.out.println("Password must contains at least one lower case letter");
            return false;
        }
        if(!checkDigit(newPassword)){
            System.out.println("Password must contains at least one digit");
            return false;
        }
        if(!checkSpecialChar(newPassword)){
            System.out.println("Password must contains at least one special character like, @,#,$,%,&,*");
            return false;
        }
        return true;
    }
    public boolean checkUpperCase(String newPassword){
        int n=newPassword.length();
        for(int i=0; i<n; i++){
            char c=newPassword.charAt(i);
            if(c>='A' && c<='Z'){
                return true;
            }
        }
        return false;
    }
    public boolean checkLowerCase(String newPassword){
        int n=newPassword.length();
        for(int i=0; i<n; i++){
            char c=newPassword.charAt(i);
            if(c>='a' && c<='z'){
                return true;
            }
        }
        return false;
    }
    public boolean checkDigit(String newPassword){
        int n=newPassword.length();
        for(int i=0; i<n; i++){
            char c=newPassword.charAt(i);
            if(c>='0' && c<='9'){
                return true;
            }
        }
        return false;
    }
    public boolean checkSpecialChar(String newPassword){
        int n=newPassword.length();
        for(int i=0; i<n; i++){
            char c=newPassword.charAt(i);
            if(c<'A' || c>'Z' && c<'a' || c>'z' && c<'0' || c>'9'){
                return true;
            }
        }
        return false;
    }
}
