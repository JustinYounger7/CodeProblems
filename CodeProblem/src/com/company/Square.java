/***********************************************************************************************************************
 * @Class: Square class used to generate the square shape generation and handle the label injection
 * @Author: Justin Younger
 * @Version: 1.0
 * @Date: 8/3/2020
 **********************************************************************************************************************/

package com.company;


public class Square implements Shape {

    // Constructor for square
    public Square(int height, int row, String label) {

        // loop to iterate the height of the shape and create the rows
        for (int i = 1; i <= height; i++) {

            // check to see if the current row is the row where the label goes, if it is not, then print a row X
           if(i == row) {

               // variable to calculate how many spaces are around the label
               int remainder = height - label.length();

               // loop to inject X characters to the left of the label
               for (int j = 0; j < remainder/2.0; j++) {
                   System.out.print("X ");
               }

               // check to see if the height/row of the square is the same size or larger than the label
               // if it is, go ahead and print the entire label,
               // if it is not then, only print the label's characters
               // equivalent to the size of the row that is being placed on
               if (height >= label.length()) {
                   for (int k = 0; k < label.length(); k++) {
                       System.out.print(label.charAt(k) + " ");
                   }

               // otherwise print based the height/row size
               } else {
                   for (int k = 0; k < height; k++) {
                       System.out.print(label.charAt(k) + " ");
                   }
               }

               // loop to inject X characters to the right of the label
               for (int l = 0; l < remainder/2; l++) {
                   System.out.print("X ");
               }
           }

           // otherwise, print a row of X's
            else {
                // prints X's equivalent to the row size
               for (int j = 0; j < height; j++) {
                   System.out.print("X ");
               }
            }

            // move to the new line
            System.out.println(" ");
        }
    }
}
