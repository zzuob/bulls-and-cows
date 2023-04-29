package bullscows;

import java.util.Scanner;

enum State {
    START, TURN_NO, GUESS, END
}

public class Loop {
    String code;
    String guess;
    int turns = 0;

    private String start() {
        // set the secret code
        int codeLength = Number.getBoundedIntegerFromInput(
                "Input the length of the secret code:", 1, 36);
        int possibleCharacters = Number.getBoundedIntegerFromInput(
                "Input the number of possible symbols in the code:", codeLength, 36);
        code = Number.getRandomCode(codeLength, possibleCharacters);
        String hidden = "*".repeat(code.length());
        StringBuilder range = new StringBuilder("(0-");
        int maxDigit = possibleCharacters < 10 ? possibleCharacters - 1 : 9;
        range.append(maxDigit);
        if (possibleCharacters >= 10) {
            range.append(", a-");
            int maxCharIndex = possibleCharacters + 87 - 1; // 1st character = 0
            range.append((char) maxCharIndex);
        }
        range.append(")");
        guess = "";
        return String.format("The secret code is prepared: %s %s", hidden, range);
    }

    private String stateTurnNo() {
        // update turn number
        turns++;
        return String.format("Turn %d. Answer:", turns);
    }

    private String guessCode() {
        // let the user input a guess and evaluate the grade
        Scanner scan = new Scanner(System.in);
        guess = "";
            if (scan.hasNext()) {
                guess = scan.next().trim();
            }
        String result = Grade.getGrade(code, guess);
        return String.format("Grade: %s", result);
    }

    private String endGame() {
        return String.format("Congrats! The secret code is %s.", code);
    }

    public void play() {

        State state = State.START;
        while(state != State.END) {
            String message = "";
            switch (state) {
                case START -> {
                    message = start();
                    state = State.TURN_NO;
                }
                case TURN_NO -> {
                    message = stateTurnNo();
                    state = State.GUESS;
                }
                case GUESS -> {
                    message = guessCode();
                    state = code.equals(guess) ? State.END : State.TURN_NO;
                }
            }
            System.out.println(message);
        }
        System.out.println(endGame());

    }


}
