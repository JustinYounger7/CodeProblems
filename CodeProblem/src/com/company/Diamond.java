/***********************************************************************************************************************
 * @Class: Diamond class used to generate the diamond shape generation and handle the label injection
 * @Author: Justin Younger
 * @Version: 1.0
 * @Date: 8/3/2020
 **********************************************************************************************************************/

package com.company;

public class Diamond implements Shape {

    // Constructor for diamond
    public Diamond(int height, int row, String label) {

        // variable to calculate how many spaces are around the label
        int remainder = row - label.length();

        // loop that creates the top half rows of the diamond, starting from 0 to half of the diamond
        for (int i = 0; i < Math.ceil(height/2.0); i++) {

            // check to see if the current row is the row where the label goes, if it is not, then print a row X
            if(i+1 == row) {
                // loop to generate spaces based of the row size
                for (int j = 1; j < height - i; j++) {
                    System.out.print(" ");
                }

                // loop to inject X characters to the left of the label, if needed
                if(remainder > 0) {
                    for (int k = 0; k < remainder / 2.0; k++) {
                        System.out.print("X ");
                    }
                }

                // check to see if the row is the same size or larger than the label
                // if it is, then print the entire label,
                // if it is not then, only print the label's characters
                // equivalent to the size of the row that is being placed on
                if(row > label.length()) {
                    for (int k = 0; k < label.length(); k++) {
                        System.out.print(label.charAt(k) + " ");
                    }

                // otherwise, print based off the row size
                } else {
                    for (int k = 0; k < row; k++) {
                        System.out.print(label.charAt(k) + " ");
                    }
                }

                // loop to inject X characters to the right of the label, if needed
                if(remainder > 0) {
                    for (int m = 1; m <= remainder / 2.0; m++) {
                        System.out.print("X ");
                    }
                }

                // otherwise print a row of X's
            } else {
                // loop to make spaces based on row size
                for (int j = 1; j < height - i; j++) {
                    System.out.print(" ");
                }
                // loop to print X's equivalent to row size
                for (int k = 0; k <= i; k++) {
                    System.out.print("X ");
                }
            }
            // move to the next row
            System.out.println("");
        }

        // loop that creates the bottom half rows of the diamond, starting from half of the diamond to the height
        for (double i = Math.floor(height/2.0); i < height; i++) {
            // check to see if the current row is the row where the label goes, if it is not, then print a row X
            if(i+1 == row) {
                // variable to calculate how many spaces are around the label
                remainder = (int)i - label.length();

                    // loop to make spaces based on row size
                    for (double j = i+1; j > 1; j--) {
                        System.out.print(" ");
                    }

                    // loop to inject X characters to the left of the label, if needed
                    if(remainder > 0) {
                        for (int k = 0; k < remainder / 2.0; k++) {
                            System.out.print("X ");
                        }
                    }

                    // check to see if the row is the same size or larger than the label
                    // if it is, then print the entire label,
                    // if it is not then, only print the label's characters
                    // equivalent to the size of the row that is being placed on
                    if(row > label.length()) {
                        for (int k = 0; k < label.length(); k++) {
                            System.out.print(label.charAt(k) + " ");
                        }
                        // otherwise, print based off the row size
                    } else {
                        for (int k = 0; k < height-i; k++) {
                            System.out.print(label.charAt(k) + " ");
                        }
                    }

                    // loop to inject X characters to the right of the label, if needed
                    if(remainder > 0) {
                        for (int m = 1; m <= remainder / 2.0; m++) {
                            System.out.print("X ");
                        }
                    }
                // otherwise print a row of X's
            } else {
                // loop to make spaces based on row size
                for (double j = i+1; j > 1; j--) {
                    System.out.print(" ");
                }
                // loop to print X's equivalent to row size
                for (double k = i; k < height; k++) {
                    System.out.print("X ");
                }
            }

            // move to the next row
            System.out.println("");
        }
    }
}
