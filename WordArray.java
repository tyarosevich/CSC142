
/* Homework 1 - WordArray
 * Trent Yarosevich
 * CSC 142 Hybrid
 * Instrucotr: Joe Hueffed
 * 01/26/2016
 * 
 * This program accepts a dynamic number of word inputs from the 
 * user, and then prompts them for a search word. The program
 * then outputs the number of words from their inputs that match
 * the search word.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordArray {

    // This method searches a passed ArrayList for a passed
    // search word and returns the total number of times
    // the search word appears in the list as an integer.
    public static int CountWords(List<String> wordList, String searchWord) {

        int wordTotal = 0;

        // Iterates through the list and increments the
        // wordTotal counter when a match is found.
        for (String listItem : wordList) {
            if (listItem.toLowerCase().equals(searchWord)) {
                wordTotal += 1;
            }
        }

        return wordTotal;

    }

    public static void main(String[] args) {

		/*
         * Initializes a list to hold user input words, a string variable to act
		 * as sentinel condition in while loop, a scanner object, a holder
		 * variable for the user's search word, and an int counter to track
		 * number of search matches.
		 */
        List<String> wordList = new ArrayList<String>();
        String newWord = new String("");
        Scanner scanner = new Scanner(System.in);
        String searchWord;
        int wordTotal;

        // Prompts the user to input a word.
        System.out.print(
                "Please input a word to add to the list and press return after each word (no spaces). When finished, type 'done': ");

        // A while loop that captures a user input of a word,
        // then adds this word to the ArrayList wordList until
        // they input the word 'done'.
        while (!newWord.equals("done")) {
            newWord = (scanner.next());
            //I think u can change this do a do while, and have the if check the regex.
            // Checks to see if the entry is 'done'. If not, the entry
            // is added to the list. If they input 'done', the loop breaks.
            if (!newWord.equals("done")) {
                wordList.add(newWord);

            } else {
                break;
            }
        }

        // Prompts the user for the word they want to search for, and
        // sets it to lower-case.
        System.out.print("Please input the word in the list you want to search for: ");
        searchWord = scanner.next().toLowerCase();

        // Iterates through each of the words the user input, changing
        // them to lower-case and checking to see if they match the search word.
        // Each successful match increases the counter variable by 1.
        wordTotal = CountWords(wordList, searchWord);


        // And if statement to account for singular or plural. If the counter is
        // 1, an output informs the user of a single match. If it's more than one,
        // the else if condition informs them of the number of matches. If the
        // counter is 0, the user is informed that there are no matches.
        if (wordTotal == 1) {
            System.out.print("The list of words contains the word " + "'" + searchWord + "'" + " " + wordTotal + " time.");
        } else if (wordTotal > 1) {
            System.out.print("The list of words contains the word " + "'" + searchWord + "'" + " " + wordTotal + " times.");

        } else {
            System.out.print("The list of words does not contain the word " + "'" + searchWord + "'.");
        }
    }

}
