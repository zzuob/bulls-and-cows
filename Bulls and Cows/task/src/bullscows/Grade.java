package bullscows;

public class Grade {

    public static String getGrade(String code, String guess) {
        int bulls = 0, cows = 0;
        for (int i = 0; i < Math.min(guess.length(), code.length()); i++) {
            if (guess.charAt(i) == code.charAt(i)) {
                bulls++;
            } else if (code.matches(".*" + guess.charAt(i) + ".*")) {
                cows++;
            }
        }
        return formatBullsAndCows(bulls, cows);
    }

    private static String formatBullsAndCows(int bulls, int cows) {
        if (bulls == 0 && cows == 0) {
            return "None.";
        } else if (cows == 0) {
            return bulls == 1 ? "1 bull." : String.format("%d bulls.", bulls);
        } else if (bulls == 0) {
            return cows == 1 ? "1 cow." : String.format("%d cows.", cows);
        } else {
            if (bulls == 1 && cows == 1) {
                return "1 bull and 1 cow.";
            } else if (bulls == 1) {
                return String.format("1 bull and %d cows.", cows);
            } else if (cows == 1) {
                return String.format("%d bulls and 1 cow.", bulls);
            } else {
                return String.format("%d bulls and %d cows.", bulls, cows);
            }
        }
    }
}
