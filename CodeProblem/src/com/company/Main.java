/***********************************************************************************************************************
* @Class: Main
* @Author: Justin Younger
* @Version: 1.0
* @Date revised: 8/3/2020
***********************************************************************************************************************/
package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize scanner
	    Scanner scan = new Scanner(System.in);

	    // Prompt user for shape type
        System.out.print("What shape should I draw? (triangle / square / diamond): ");
        String shape = " ";

        // Loop to see if the shape given is triangle, square, or diamond. If it is not, throw an InputMismatchException
        // that then prompts the user to try again.
        while(!shape.equalsIgnoreCase("triangle") && !shape.equalsIgnoreCase("square") &&
                !shape.equalsIgnoreCase("diamond")) {
            try {
                shape = scan.nextLine().toLowerCase();
                switch(shape) {
                    case "triangle":
                    case "square":
                    case "diamond":
                        break;
                    default:
                        throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.print("Incorrect input, please input triangle, square, or diamond: ");
                shape = scan.next();
            }
        }

        // Prompts user for the height of the shape
        int height = 0;
        System.out.print("How tall should the " + shape + " be? ");

        // Loop to see if the input was a positive integer, if it was not prompt user to enter a positive integer, also
        // catches any InputMismatchExceptions and prompts with the same message
        while(!(height >= 1)) {
            try {
                height = scan.nextInt();
                if(height <= 0) {
                    System.out.print("Incorrect input, please input a positive integer: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Incorrect input, please input a positive integer: ");
                scan.next();
            }
        }

        // Prompts the user to input a label or leave blank for it to automatically be LU.
        String label = " ";
        System.out.print("What label should be printed on the " + shape + " (Leave blank for \"LU\")? ");
        scan.nextLine();
        label = scan.nextLine();

        // Check to check if it was left blank, if it was, then set label to LU
        if(label.equals("")){
            label = "LU";
        }

        // Prompts user to choose which row the label should be placed
        int row = 0;
        System.out.print("On what row should the label " + label +  " be printed? ");

        // Loop to verify that the inputted value was not 0 and the row was not greater than the height of the shape
        // if it was, then prompt user to try again and also catch any InputMismatchExceptions with the same prompt.
        while(row == 0 || row > height) {
            try {
                row = scan.nextInt();
                if(row > height) {
                    System.out.print("Incorrect input, please enter a positive integer that " +
                            "is smaller than the height of the shape: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Incorrect input, please enter a positive integer that " +
                        "is smaller than the height of the shape: ");
                scan.next();
            }
        }

        // Switch statement that creates the appropriate shape object based off the given shape
        switch(shape) {
            case "triangle":
                Triangle triangle = new Triangle(height, row, label);
                break;
            case "square":
                Square square = new Square(height, row, label);
                break;
            case "diamond":
                Diamond diamond = new Diamond(height, row, label);
                break;
        }


        String answer = "";
        // Prompts user if they would like to print another shape or not
        System.out.print("Would you like me to print another shape? (Y/N) ");

        // Exit loop, if user wants to create another shape then call Main() again
        // if user wants to exit, close the scanner object, print good bye, and exit system with code 0.
        // finally, if user does input Y or N, provider error message and request correct input
         while(!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
            answer = scan.next();
            if(answer.equalsIgnoreCase("Y")) {
                main(null);
            } else if (answer.equalsIgnoreCase("N")) {
                scan.close();
                System.out.println("Good bye!");
                System.exit(0);
            } else {
                System.out.print("Incorrect input, please input Y or N: ");
            }
         }
    }
}
