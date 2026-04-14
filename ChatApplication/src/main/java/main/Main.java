/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import services.Login;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Main {
     public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Create an instance of the Login service
        Login loginService = new Login();
        
        // Welcome message
        System.out.println("=".repeat(50));
        System.out.println("     WELCOME TO QUICKCHAT");
        System.out.println("=".repeat(50));
        
        boolean running = true;
        
        // Main application loop
        while (running) {
            // Display menu options
            System.out.println("\nPlease select an option:");
            System.out.println("1. Register New Account");
            System.out.println("2. Login to Existing Account");
            System.out.println("3. Exit Application");
            System.out.print("Enter your choice (1-3): ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    // REGISTRATION PROCESS
                    System.out.println("\n--- REGISTRATION FORM ---");
                    
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    
                    System.out.print("Create Username (must contain '_' and be ≤ 5 characters): ");
                    String username = scanner.nextLine();
                    
                    System.out.print("Create Password (8+ chars, 1 capital, 1 number, 1 special char): ");
                    String password = scanner.nextLine();
                    
                    System.out.print("Enter Cell Phone Number (format: +27XXXXXXXXX): ");
                    String cellPhone = scanner.nextLine();
                    
                    // Call registerUser method and display result
                    String registrationResult = loginService.registerUser(username, password, 
                                                                          cellPhone, firstName, lastName);
                    System.out.println("\n" + registrationResult);
                    break;
                    
                case "2":
                    // LOGIN PROCESS
                    if (!loginService.isUserRegistered()) {
                        System.out.println("\nNo account found. Please register first.");
                        break;
                    }
                    
                    System.out.println("\n--- LOGIN FORM ---");
                    System.out.print("Enter Username: ");
                    String loginUsername = scanner.nextLine();
                    
                    System.out.print("Enter Password: ");
                    String loginPassword = scanner.nextLine();
                    
                    // Call returnLoginStatus method and display result
                    String loginStatus = loginService.returnLoginStatus(loginUsername, loginPassword);
                    System.out.println("\n" + loginStatus);
                    break;
                    
                case "3":
                    // EXIT APPLICATION
                    System.out.println("\nThank you for using QuickChat. Goodbye!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("\nInvalid option. Please enter 1, 2, or 3.");
                    break;
            }
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
