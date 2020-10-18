
/* Homework 3 - JUnit Testing
 * Trent Yarosevich
 * CSC 142 Hybrid
 * Instrucotr: Joe Hueffed
 * 02/11/2017
 *
 * This program runs a J Unit test for the CountWords
 * method in my WordArray Class from the first homework
 * assignment. Note this is a modification of the original
 * WOrdArray class, and thus this Unit Testing class requires
 * the updated WordArray class to function properly.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordArrayTest {
    @org.junit.Test
    public void countWords() throws Exception {

        // Initializes some variables for the test, including the
        // test object, a simple static list containing the words
        // and the test word that appears twice in the test list.
        WordArray test = new WordArray();
        List<String> testList = Arrays.asList("in", "a", "hole", "in", "the", "ground", "there", "lived", "a", "hobbit");
        String testWord = "in";

        //Initializes the output by passing the test list and word
        // to the CountWords method, and asserts the correct
        // number that the method should return.
        int output = test.CountWords(testList, testWord);
        assertEquals(2, output);
    }

}