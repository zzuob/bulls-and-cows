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
        code = Number.getRandomFromInput();
        String hidden = "*".repeat(code.length());
        guess = "";
        return String.format("The secret code is prepared: %s", hidden);
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
            switch(state) {
                case START:
                    message = start();
                    state = State.TURN_NO;
                    break;
                case TURN_NO:
                    message = stateTurnNo();
                    state = State.GUESS;
                    break;
                case GUESS:
                    message = guessCode();
                    state = code.equals(guess) ? State.END : State.TURN_NO;
                    break;
            }
            System.out.println(message);
        }
        System.out.println(endGame());

    }


}
