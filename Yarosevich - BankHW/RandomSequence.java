package BankHW;

import java.util.Random;

// A class top level class to create sequences
// of randomly generated numbers up to about 14 or 15
// in length.
public final class RandomSequence {
    private static final int MAX = 9;
    private static final int MIN = 0;


    private RandomSequence() {

    }
    // This method passes an int that determines the length
    // of the sequence of numbers to be generated.
    public static long intSequenceGen(int length){

        // Initializes string builder and random objects then iterates
        // based on the length parameter, adding random integers between
        // 0-9 to the string builder. Then converts the stringbuilder object
        // to a long and returns it.
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.delete(0 , length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(MAX - MIN + 1) + MIN);
        }
        return Long.parseLong(sb.toString());
    }
}
