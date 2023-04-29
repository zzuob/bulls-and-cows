package bullscows;

import java.util.Scanner;

public class Number {

    public static String getRandomFromInput() {
        Scanner scan = new Scanner(System.in);
        int length = 0;
        while (true) {
            System.out.println("Please, enter the secret code's length:");
            try {
                if (scan.hasNextInt()) {
                    length = scan.nextInt();
                    return getRandomNumber(length);
                }
            } catch (Exception e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
    }


    public static String getRandomNumber(int length) {
        // generate a pseudorandom number, with no repeated digits, that does not start with 0
        if (length > 10) {
            String message = String.format("can't generate a secret number with a length of %d", length);
            message = message + " because there aren't enough unique digits";
            throw new ArrayIndexOutOfBoundsException(message);

        }
        StringBuilder result = new StringBuilder();
        while(result.length() < length) {
            // generate digits, will loop until completed if not enough distinct digits in pseudoRandomNumber
            long pseudoRandomNumber = System.nanoTime();
            String stringNumber = String.valueOf(pseudoRandomNumber);
            for (int i = 0; i < stringNumber.length(); i++) {
                if (result.length() == length) {
                    break;
                }
                String newDigit = String.valueOf(stringNumber.charAt(i));
                String exclude = "((?![" + result + "]).)"; // does not compile if result is empty
                if (result.isEmpty()) {
                    if (!"0".equals(newDigit)) { // result cannot start with "0"
                        result.append(newDigit); // append first digit, regex exclude will now compile
                    }
                } else if (newDigit.matches(exclude)) { // do not repeat digits
                    result.append(newDigit);
                }
            }
        }
        return result.toString();
    }
}
