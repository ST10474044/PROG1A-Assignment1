# PROG1A-Assignment1
# Chat Application - Part 1: Registration and Login Feature

## Project Overview

This is a console-based Java application that implements a user registration and login system for a chat application. The application validates user inputs according to specific business rules and provides appropriate feedback messages.

**Author:** [Sreya Singh]  
**Student ID:** [ST10474044]  
**Module:** POE - Chat Application  
**Date:** [14-04-2026]

## Features

### Registration Feature
- Users can create an account by entering:
  - First name
  - Last name
  - Username
  - Password
  - South African cell phone number

### Validation Features
- **Username Validation:** Must contain an underscore (_) and be no more than 5 characters long
- **Password Validation:** Must meet complexity requirements:
  - At least 8 characters long
  - Contain at least one capital letter
  - Contain at least one number
  - Contain at least one special character
- **Cell Phone Validation:** Must contain the South African international code (+27) followed by 9 digits

### Login Feature
- Users can log in using their registered username and password
- System displays welcome message with user's first and last name upon successful login
- System displays error message for invalid login attempts

### Testing Features
- Comprehensive JUnit tests for all validation methods
- All tests use assertEquals as required by the assignment
Youtube Video Link : https://www.youtube.com/watch?v=CoaUMa0VV1U


