package week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dec1 {
    public static void main(String[] args) {
        int total_value = 0;
        String file_path = "/Users/rileywoolf/school/2023/cs393/advent_of_code/src/main/dec1.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;

            // Read each line from the file.
            while ((line = br.readLine()) != null) {
                // Add together all the calibration values from each line for the final calibration value.
                total_value += calibration_value_from_line_REAL(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total Calibration Value: " + total_value);
    }

    // ----------------------------------------------------PART ONE----------------------------------------------------
    // Finds the calibration value in the given line.
    // Putting the first digit and the second digit together to form a single, two-digit number.
    // If only one digit in the line, it is used for both the first and second digit.
    private static int calibration_value_from_line(String line) {
        return Integer.valueOf(String.valueOf(first_digit(line)) + String.valueOf(second_digit(line)));
    }

    // Start at front of line and loop until a digit is found.
    private static char first_digit(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                return line.charAt(i);
            }
        }
        return ' ';
    }

    // Start at the end of the line and loop until a digit is found.
    private static char second_digit(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            if (Character.isDigit(line.charAt(i))) {
                return line.charAt(i);
            }
        }
        return ' ';
    }

    // ----------------------------------------------------PART TWO----------------------------------------------------
    // Strings ALSO count as valid digits: one, two, three, four, five, six, seven, eight, nine
    private static int calibration_value_from_line_REAL(String line) {
        return Integer.valueOf(String.valueOf(first_digit_REAL(line)) + String.valueOf(second_digit_REAL(line)));
    }

    // Start at front of line and loop until a digit is found.
    private static char first_digit_REAL(String line) {
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                return c;
            } else if (c == 'o' || c == 't' || c == 'f' || c == 's' || c == 'e' || c == 'n') {
                //Check if the first character is o, t, f, s, e, or n, then it could be a spelled-out number.
                switch (c) {
                    case 'e' -> {
                        // Could be eight.
                        if (i + 4 < line.length()) {
                            if (line.startsWith("eight", i)) {
                                return '8';
                            }
                        }
                    }
                    case 'f' -> {
                        // Could be four or five.
                        if (i + 3 < line.length()) {
                            if (line.startsWith("four", i)) {
                                return '4';
                            } else if (line.startsWith("five", i)) {
                                return '5';
                            }
                        }
                    }
                    case 'n' -> {
                        // Could be nine.
                        if (i + 3 < line.length()) {
                            if (line.startsWith("nine", i)) {
                                return '9';
                            }
                        }
                    }
                    case 'o' -> {
                        // Could be one.
                        if (i + 2 < line.length()) {
                            if (line.startsWith("one", i)) {
                                return '1';
                            }
                        }
                    }
                    case 's' -> {
                        // Could be six or seven.
                        if (i + 2 < line.length()) {
                            if (line.startsWith("six", i)) {
                                return '6';
                            }
                        }
                        if (i + 4 < line.length()) {
                            if (line.startsWith("seven", i)) {
                                return '7';
                            }
                        }
                    }
                    case 't' -> {
                        // Could be two or three.
                        if (i + 2 < line.length()) {
                            if (line.startsWith("two", i)) {
                                return '2';
                            }
                        }
                        if (i + 4 < line.length()) {
                            if (line.startsWith("three", i)) {
                                return '3';
                            }
                        }
                    }
                }
            }
        }
        return ' ';
    }

    // Start at the end of the line and loop until a digit is found.
    //Check if the last character is e (one, three, five, nine), n (seven), o (two),
    // r (four), t (eight), or x (six) then it could be a spelled-out number.
    private static char second_digit_REAL(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                return c;
            } else if (c == 'e' || c == 'n' || c == 'o' || c == 'r' || c == 't' || c == 'x') {
                switch (c) {
                    case 'e' -> {
                        // Could be one, three, five, or nine.
                        if (i - 2 > -1) {
                            if (line.startsWith("one", i - 2)) {
                                return '1';
                            }
                        }
                        if (i - 3 > -1) {
                            if (line.startsWith("five", i - 3)) {
                                return '5';
                            } else if (line.startsWith("nine", i - 3)) {
                                return '9';
                            }
                        }
                        if (i - 4 > -1) {
                            if (line.startsWith("three", i - 4)) {
                                return '3';
                            }
                        }
                    }
                    case 'n' -> {
                        // Could be seven.
                        if (i - 4 > -1) {
                            if (line.startsWith("seven", i - 4)) {
                                return '7';
                            }
                        }
                    }
                    case 'o' -> {
                        // Could be two.
                        if (i - 2 > -1) {
                            if (line.startsWith("two", i - 2)) {
                                return '2';
                            }
                        }
                    }
                    case 'r' -> {
                        // Could be four.
                        if (i - 3 > -1) {
                            if (line.startsWith("four", i - 3)) {
                                return '4';
                            }
                        }
                    }
                    case 't' -> {
                        // Could be eight.
                        if (i - 4 > -1) {
                            if (line.startsWith("eight", i - 4)) {
                                return '8';
                            }
                        }
                    }
                    case 'x' -> {
                        // Could be six.
                        if (i - 2 > -1) {
                            if (line.startsWith("six", i - 2)) {
                                return '6';
                            }
                        }
                    }
                }
            }
        }
        return ' ';
    }
}
