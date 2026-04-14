/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Models.User;

/**
 *
 * @author lab_services_student
 */
public class Login {
     // Store the registered user (singleton pattern)
    private User registeredUser;
    
  
    public boolean checkUserName(String username) {
        // Check if username contains underscore AND length is <= 5 characters
        if (username != null && username.contains("_") && username.length() <= 5) {
            return true;
        }
        return false;
    }
    
    
    public boolean checkPasswordComplexity(String password) {
   
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        
        if (password != null && password.matches(passwordRegex)) {
            return true;
        }
        return false;
    }
    
    
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
       
        String phoneRegex = "^\\+27[0-9]{9}$";
        
        if (cellPhoneNumber != null && cellPhoneNumber.matches(phoneRegex)) {
            return true;
        }
        return false;
    }
    
    
    public String registerUser(String username, String password, String cellPhoneNumber,
                               String firstName, String lastName) {
        
        // Check username validity
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username " +
                   "contains an underscore and is no more than five characters in length.";
        }
        
        // Check password complexity
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password " +
                   "contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        // Check cell phone number validity
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        
        // All validations passed - create and store the user
        registeredUser = new User(username, password, cellPhoneNumber, firstName, lastName);
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }
    
   
    public boolean loginUser(String username, String password) {
        // Check if a user is registered and credentials match
        if (registeredUser != null && 
            registeredUser.getUsername().equals(username) && 
            registeredUser.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    
   
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + registeredUser.getFirstName() + ", " + 
                   registeredUser.getLastName() + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
 
    public boolean isUserRegistered() {
        return registeredUser != null;
    }
    
    public User getRegisteredUser() {
        return registeredUser;
    }
    
}
