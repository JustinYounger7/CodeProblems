/***********************************************************************************************************************
 * @Class: Triangle class used to generate the triangle shape generation and handle the label injection
 * @Author: Justin Younger
 * @Version: 1.0
 * @Date: 8/3/2020
 **********************************************************************************************************************/

package com.company;


public class Triangle implements Shape {

    // Constructor for triangle
    public Triangle(int height, int row, String label) {

        // loop to iterate the height of the shape and create the rows
        for (int i = 1; i <= height; i++)  {

            // check to see if the current row is the row where the label goes, if it is not, then print a row X
            if(i == row) {

                // variable to calculate how many spaces are around the label
                int remainder = row - label.length();

                // Creates spacing based on the current row
                for (int j = height - i; j > 0; j--) {
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
                if (row >= label.length()) {
                    for (int l = 0; l < label.length(); l++) {
                        System.out.print(label.charAt(l) + " ");
                    }
                // otherwise, print based off the row size
                } else {
                    for (int l = 0; l < row; l++) {
                        System.out.print(label.charAt(l) + " ");
                    }
                }

                // loop to inject X characters to the right of the label, if needed
                if(remainder > 0) {
                    for (int m = 1; m <= remainder / 2.0; m++) {
                        System.out.print("X ");
                    }
                }
            }
            // otherwise print a row of X
            else {
                // loop to make spaces based on row size
                for (int j = height - i; j > 0; j--) {
                    System.out.print(" ");
                }
                // loop to print X's equivalent to row size
                for (int k = 0; k < i; k++) {
                    System.out.print("X ");
                }
            }

            // move to the next row
            System.out.println(" ");
        }
    }
}
