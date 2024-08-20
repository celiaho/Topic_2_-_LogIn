/* *****************************************
 *  Author : Celia Ho   
 *  Created On : Tue Feb 20 2024
 *  File : Topic 2 - Reading Assignment (Working Draft 2)
 *  Description : Create a program that has the following data in a multi-dimensional array: 
 *    Sally, Smith, SSmith01, 123ABC, 5
 *    Fred, Flint, FFlint01, AB1235, 7
 *    Paulo, Jonas, PJonas07, 721846, 9
 *    Freida, Flint, FFlint01, CDEabc, 2
 * Column 1 corresponds to first name, column 2 corresponds to last name, column 3 corresponds to
 * username, column 4 corresponds to password, and column 5 corresponds to number of successful 
 * logins. 
 * 
 * Your program should prompt for the username and the password and search through the array to 
 * find the user.  If the user is there, your program should update the number of times that user 
 * has logged in, then print the user's first and last name and the number of times that user has 
 * logged in.  Use methods where appropriate.  Allow for continuous runs of the program (AVOID 
 * WHILE TRUE!)
 * 
 * Output should look like this:
 * 
 * Enter username to search for: FFlint01
 * Enter password: AB1235
 * Found Fred Flint. They have logged in 8 times.
 * Continue (y/n)? y
 * Enter username to search for: FFlint01
 * Enter password: CDEabc
 * Found Freida Flint. They have logged in 3 times.
 * Continue (y/n)? y
 * Enter username to search for: FFlint01
 * Enter password: CDEabc
 * Found Freida Flint. They have logged in 4 times.
 * Continue (y/n)? y
 * Enter username to search for: PJonas07
 * Enter password: 12345
 * A user with username PJonas07 and password 12345 is not found.
 * Continue (y/n)? n
 * ******************************************/

import java.io.File;
import java.util.Scanner;

public class LogIn {

  public static void main(String[] args) {
  // Manual array creation method
  // Create a program that has the following data in a multi-dimensional array: 
    // Sally, Smith, SSmith01, 123ABC, 5
    // Fred, Flint, FFlint01, AB1235, 7
    // Paulo, Jonas, PJonas07, 721846, 9
    // Freida, Flint, FFlint01, CDEabc, 2
    // column 1 corresponds to first name, column 2 corresponds to last name, column 3 corresponds to username, column 4 corresponds to password, and column 5 corresponds to number of successful logins. 
    String[][] logins = {
      {"Sally", "Smith", "SSmith01", "123ABC", "5"},
      {"Fred", "Flint", "FFlint01", "AB1235", "7"},
      {"Paulo", "Jonas", "PJonas07", "721846", "9"},
      {"Freida", "Flint", "FFlint02", "CDEabc", "2"},
    };
  
    Scanner input = new Scanner(System.in); 
    
    String cont;

    // Allow for continuous runs of the program (AVOID WHILE TRUE!) //*** HOW
    do {
      // Prompt for the username 
    System.out.println("Enter user name to search for: ");
    // Store username from keyboard input
    String username = input.nextLine();

    // Prompt for the password 
    System.out.println("Enter password: ");
    // Store password from keyboard input
    String password = input.nextLine();

    // search through the array to find the user. 
    int index = linearSearch(logins, username, password); // Position of element found

    if (index != -1) {
      // then print the user's first and last name and the number of times that user has logged in.
      System.out.println("Found " + logins[index][0] + " " + logins[index][1] + ". They have logged in " + logins[index][4] + " times.");
    }
    else if (index == -1)
    // Print error message
    System.out.println("A user with username " + username + " and password " + password + " is not found.");
    // return Integer.parseInt(logins[i][4]);

    /*
    // If the user is there,
      if (numberOfLogins) {
        // update the number of times that user has logged in
          numberOfLogins += 1;

        // then print the user's first and last name and the number of times that user has logged in.  
        System.out.println("Found " + logins[i][0] + logins[i][1] + ". They have logged in " + numberOfLogins + " times.");
      // if key is not found
      else if (linearSearch(logins, username) == -1 || linearSearch(logins, password) == -1) {
        // Print error message
        System.out.println("A user with username " + logins[i][2] + " and password " + logins[i][3] + " is not found.");
  */

    // Allow for continuous runs of the program (AVOID WHILE TRUE!) //*** HOW
    // while (true)
    // while(input.hasNextLine()) {
      System.out.println("Continue (y/n)? ");
      cont = input.nextLine();
      // System.out.println(cont.length());

      // If continue == n,
      if (cont.equalsIgnoreCase("n")) {
        // System.out.println("xyz");
        // end program
        break; 
      }
    } while (!cont.equalsIgnoreCase("n")); // As long as it's not equal to n, keep going
        
  }

  public static int linearSearch (String[][] array, String usernameTarget, String passwordTarget) {
    for (int i = 0; i < array.length; i++) {
      /* // ***TESTS to see why if statement doesn't work
      // System.out.println(array[i][2] + " " + array[i][3]);   
      // System.out.println(array[i][2] == usernameTarget);
      // System.out.println(array[i][3] == passwordTarget);
      */
      // If user and password are found
      if (array[i][2].equals(usernameTarget) && array[i][3].equals(passwordTarget)) {
        // update the number of times that user has logged in
        int number = Integer.parseInt(array[i][4]) + 1;
        array[i][4] = String.valueOf(number);
        return i;
      }
      // if key is not found
    }
    return -1;
  }
}


/* ***Attempt #2: Array creation from input file - commented out to create array manually
  // Create a multi-dimensional array of 4 rows with 5 elements each
  double[][] logins = new double[4][5];

  // Read from file
    File file = new File("logins.txt");

    Scanner fileReader = new Scanner(file);

    int i = 0;

    // Read lines from a file with a while loop
    while (fileReader.hasNextLine()) {
      String inputString = fileReader.nextLine();
    
      // Split line by delimiter ", " and save data to an array of strings called "temp"
      String[] temp = inputString.split(", ");

      logins[i][0] = String.parseString(temp[0]); // first names
      logins[i][1] = temp[1]; // last names
      logins[i][2] = temp[2]; // usernames
      logins[i][3] = temp[3]; // passwords
      logins[i][4] = temp[4]; // successful logins
      
      // Increment array
      i++;

      // Test that usernames were stored correctly
      System.out.println(temp[2]);
    }
  */