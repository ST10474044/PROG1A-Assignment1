/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import services.Login;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class LoginTest {
     private Login loginService;
    
    // This method runs before each test to create a fresh Login instance
    @BeforeEach
    public void setUp() {
        loginService = new Login();
    }

    @Test
    public void testCheckUserName_Valid() {
        String testUsername = "kyl_1";
        boolean result = loginService.checkUserName(testUsername);
        
        // Using assertEquals as required by the assignment
        assertEquals(true, result, "Username 'kyl_1' should be valid (contains underscore, length ≤ 5)");
    }
    

    @Test
    public void testCheckUserName_Invalid() {
        String testUsername = "kyle!!!!!!!";
        boolean result = loginService.checkUserName(testUsername);
        
        assertEquals(false, result, "Username 'kyle!!!!!!!' should be invalid (no underscore)");
    }
    
    @Test
    public void testCheckPasswordComplexity_Valid() {
        String testPassword = "Ch&sec@ke99!";
        boolean result = loginService.checkPasswordComplexity(testPassword);
        
        assertEquals(true, result, "Password 'Ch&sec@ke99!' should be valid (8+ chars, capital, number, special)");
    }
    
    
    @Test
    public void testCheckPasswordComplexity_Invalid() {
        String testPassword = "password";
        boolean result = loginService.checkPasswordComplexity(testPassword);
        
        assertEquals(false, result, "Password 'password' should be invalid (no capital, no number, no special)");
    }
    

    @Test
    public void testCheckCellPhoneNumber_Valid() {
        String testPhone = "+27838968976";
        boolean result = loginService.checkCellPhoneNumber(testPhone);
        
        assertEquals(true, result, "Cell phone '+27838968976' should be valid (contains +27 international code)");
    }
    
    // ============ TEST 6: INVALID CELL PHONE ============
    /**
     * Test Data: "08966553"
     * Expected Result: false (Cell phone number incorrectly formatted)
     */
    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        String testPhone = "08966553";
        boolean result = loginService.checkCellPhoneNumber(testPhone);
        
        assertEquals(false, result, "Cell phone '08966553' should be invalid (no international code)");
    }
    
    // ============ EXTRA TEST: REGISTRATION SUCCESS MESSAGE ============
    @Test
    public void testRegisterUser_Success() {
        String result = loginService.registerUser("kyl_1", "Ch&sec@ke99!", 
                                                  "+27838968976", "John", "Doe");
        
        assertEquals("Username successfully captured.\nPassword successfully captured.\n" +
                    "Cell phone number successfully added.", result);
    }
    
    // ============ EXTRA TEST: REGISTRATION USERNAME FAILURE ============
    @Test
    public void testRegisterUser_InvalidUsername() {
        String result = loginService.registerUser("invalid", "Ch&sec@ke99!", 
                                                  "+27838968976", "John", "Doe");
        
        assertEquals("Username is not correctly formatted; please ensure that your username " +
                    "contains an underscore and is no more than five characters in length.", result);
    }
    

    @Test
    public void testLoginUser_Success() {
        // First register a user
        loginService.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "John", "Doe");
        
        // Then test login
        boolean result = loginService.loginUser("kyl_1", "Ch&sec@ke99!");
        
        assertEquals(true, result, "Login should succeed with correct credentials");
    }

    @Test
    public void testLoginUser_Failure() {
        // First register a user
        loginService.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "John", "Doe");
        
        // Then test login with wrong password
        boolean result = loginService.loginUser("kyl_1", "wrongpassword");
        
        assertEquals(false, result, "Login should fail with incorrect password");
    }
    
   
    @Test
    public void testReturnLoginStatus_Success() {
        loginService.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "John", "Doe");
        
        String result = loginService.returnLoginStatus("kyl_1", "Ch&sec@ke99!");
        
        assertEquals("Welcome John, Doe it is great to see you again.", result);
    }
    
    
    @Test
    public void testReturnLoginStatus_Failure() {
        loginService.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "John", "Doe");
        
        String result = loginService.returnLoginStatus("kyl_1", "wrongpassword");
        
        assertEquals("Username or password incorrect, please try again.", result);
    }
    
}
