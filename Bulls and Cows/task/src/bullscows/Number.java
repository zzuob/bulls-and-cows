package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Number {

    public static int getBoundedIntegerFromInput(String prompt, int minValue, int maxValue) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println(prompt);
            try {
                if (scan.hasNextInt()) {
                    int result = scan.nextInt();
                    if ((minValue <= result && result <= maxValue)) {
                        return result;
                    } else {
                        System.out.printf("Error: Enter a number between %d and %d\n", minValue, maxValue);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
    }


    public static String getRandomCode(int length, int possibleSymbols) {
        // generate a pseudorandom number, with no repeated digits, that does not start with 0
        if (length > 36) {
            String message = String.format("can't generate a secret number with a length of %d", length);
            message = message + " because there aren't enough unique characters";
            throw new ArrayIndexOutOfBoundsException(message);

        }
        StringBuilder result = new StringBuilder();
        while(result.length() < length) {
            // loop until result is the required length
            Random random = new Random();
            int randomNumber = random.nextInt(possibleSymbols); // possibleSymbols = 1 to 36
            String newDigit;
            if (randomNumber < 10) {
                newDigit = String.valueOf(randomNumber);
            } else { // translate random number to a-z
                int charIndex = randomNumber + 87;
                newDigit = String.valueOf((char) charIndex);
            }
            String exclude = "((?![" + result + "]).)"; // does not compile if result is empty
            if (result.isEmpty()) {
                result.append(newDigit); // append first digit, regex exclude will now compile
            } else if (newDigit.matches(exclude)) { // do not repeat digits
                result.append(newDigit);
            }
        }
        return result.toString();
    }
}
