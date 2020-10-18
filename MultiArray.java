package Homework2;

import java.util.Scanner;
import java.util.stream.IntStream;

/* Homework 2 - MultiArray
 * Trent Yarosevich
 * CSC 142 Hybrid
 * Instrucotr: Joe Hueffed
 * 01/30/2016
 *
 *This program uses nested for loops to iterate through multiarrays
 * and alter their contents based on a variety of requirements
 * specified by the assignment. The program then outputs each
 * of the arrays with print statements.
 */
public class MultiArray {

    // This method prints out the totals for each row
    // of the passed multiArray as well as the total for
    // the entire multiArray.
    public static void sumArray(int[][] localArray) {

        // Initializes a counter and an array to hold the totals of each row.
        int counter = 0;
        int[] rowTotals;
        rowTotals = new int[10];

        // Iterates through each row of the passed multiArray
        // and adds the sum of each row to the array that stores
        // the row totals.
        for (int[] row : localArray) {
            rowTotals[counter] = IntStream.of(row).sum();
            counter++;
        }

        // A for loop that sequentially prints out strings
        // that state the totals for each row.
        for (int i = 0; i < 10; i++) {
            System.out.println("Row " + (i+1) + " total is: " + rowTotals[i]);
        }

        // Prints out the total for the entire array by
        // summing the row totals array.
        System.out.println("The total for the entire array is " + IntStream.of(rowTotals).sum() + ".");
    }

    // This method prints out an array passed
    // as an argument by iterating through each item in each row
    // and printing each item with a tab
    // as a separator.
    public static void printArray(int[][] localArray) {

        for (int[] row : localArray) {
            for (int x : row) {
                System.out.print(x);
                System.out.print("\t");
            }
            System.out.println();
        }

    }

    // This method uses a for loop to iterate through each
    // row of the array. The nested for loop then iterates through an
    // i (or row) value and sets all of the current row to 0, as well
    // as the next (i+1) row to 1. The i value is then incremented
    // by 2 each time, creating alternating rows of 0's and 1's.
    public static void patternRow(int[][] localArray) {

        for (int i = 0; i < 10; i += 2) {
            for (int j = 0; j < 10; j++) {
                localArray[i][j] = 0;
                localArray[i + 1][j] = 1;

            }
        }
        // Passes the modified local array to be printed.
        printArray(localArray);
    }

    // This method creates an array with a checkered pattern. The
    // first for-loop iterates through i values (rows) by increments
    // of 2. The nested for loop then sets the j (column) values of
    // two multiplied by the current j (j*2) value to zero, then j*2 + 1 is
    // simultaneously set to 1. At the same time, the next row, or i+1,
    // has the same operation applied to it, except the j*2 value is
    // set to 1 and the j*2+1 value is set to 0. This creates a checkered
    // pattern of 1's and 0's.
    public static void patternCheckered(int[][] localArray) {
        for (int i = 0; i < 10; i += 2) {
            for (int j = 0; j < 5; j += 1) {
                localArray[i][j * 2] = 0;
                localArray[i][j * 2 + 1] = 1;
                localArray[i + 1][j * 2] = 1;
                localArray[i + 1][j * 2 + 1] = 0;
            }
        }
        printArray(localArray);
    }

    // This method takes an input of 3 integers from the user
    // and places these three integers into the multiarray
    // over and over in sequence, going left to right, row by
    // row, until the array is full.
    public static void userChoice(int[][] localArray) {

        // Initializes a scanner object, a counter, and a simple
        // array of 3 integers to hold the user's input.
        Scanner scanner = new Scanner(System.in);
        int[] userArray = new int[3];
        int counter = 0;

        // Uses a for loop to iterate through the input buffer and
        // add the integers to the small array.
        System.out.print("Please enter three integers separated by a space: ");
        for (int i = 0; i < 3; i++) {
            userArray[i] = scanner.nextInt();
        }

        // These nested for loops iterate through the multiarray
        // one item at a time, incrementing very simply by 1 each time.
        // Each item in the multiarray is set to an item in the small
        // array storing the user inputs. A counter increases each time
        // in order to cycle through the user inputs, with an if statement
        // checking the counter each time. When the counter hits 2, it is reset
        // to 0, thus cycling through it until the big multiarray is populated.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                localArray[i][j] = userArray[counter];
                if (counter < 2) {
                    counter++;
                } else {
                    counter = 0;
                }
            }
        }
        printArray(localArray);
    }


    public static void main(String[] args) {

        // Initializes a multiarray of 10x10.
        int[][] multiArray;
        multiArray = new int[10][10];

        // Nested for loops that iterate through the multiarray
        // and set the vslue of every item to 1.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multiArray[i][j] = 1;

            }
        }

        // Passes the multiarray initialized in the main method to each
        // of the other methods. Those methods then print out
        // the resulting, modified array.
        patternRow(multiArray);
        System.out.println("**********************");
        patternCheckered(multiArray);
        System.out.println("**********************");
        userChoice(multiArray);
        sumArray(multiArray);

    }

}
