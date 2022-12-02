/*
Author: Jonathan Mestel
Date: 11/22/2022
Chapter 14 Exercise
Purpose: This application should allow a user to input either their full name (first middle last) or first and last name.
The program should then be able to seperate out the different parts of the name and display them individually
*/

import java.util.Scanner;

public class NameParserApp {

    public static void main(String[] args) {
        
        //creation of scanner object
        Scanner sc = new Scanner(System.in);

        //get input from user
        System.out.print("Enter a name: ");
        String name = sc.nextLine();
        System.out.println();
        
        // trim name to remove excess spaces
        name = name.trim();
        
        //test for location of first space (error if negative is returned)
        int index1 = name.indexOf(" ");
        if (index1 == -1) {
            System.out.println("Name not in valid format.");
        } else {
            //test for location of possible second space (if found, start code section to dispaly first, middle, last names)
            int index2 = name.indexOf(" ", index1 + 1);
            if (index2 == -1) {
                String firstName = name.substring(0, index1);
                String lastName = name.substring(index1 + 1);
                System.out.println("First name:  " + firstName);
                System.out.println("Last name:   " + lastName);
            } else {
                //test for thrid space (if this is pressent then send an error)
                int index3 = name.indexOf(" ", index2 + 1);
                if (index3 == -1) {
                    String firstName = name.substring(0, index1);
                    String middleName = name.substring(index1 + 1, index2);
                    String lastName = name.substring(index2 + 1);
                    
                    System.out.println("First name:  " + firstName);
                    System.out.println("Middle name: " + middleName);
                    System.out.println("Last name:   " + lastName);
                    
                } else {
                    System.out.println("Name not in valid format.");
                }
            }
        }   
    }
}
