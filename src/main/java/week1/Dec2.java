package week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dec2 {
    // ----------------------------------------------------PART ONE----------------------------------------------------
//    private static final int RED_LIMIT = 12;
//    private static final int GREEN_LIMIT = 13;
//    private static final int BLUE_LIMIT = 14;
//
//    public static void main(String[] args) {
//        // Tally up the ids of games that would have been possible if the bag contained
//        // only 12 red, 13 green, and 14 blue.
//
//        // In first 5 games of output, game 1, 3, and 4, so total is 8.
//
//        int total_value = 0;
//        int id_val = 1;
//        String file_path = "/Users/rileywoolf/school/2023/cs393/advent_of_code/src/main/dec2.txt";
//        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
//            String line;
//            // Get a line from the file, its game ID is the line number.
//            while ((line = br.readLine()) != null) {
////                if (id_val == 6) {
////                    break;
////                }
//                boolean valid = true;
//                // Remove/ignore the "Game XX:" part of the string.
//                String subset = line.substring(line.indexOf(':') + 1);
//                subset = subset.trim();
//
//                // Split the string based on ';', that will give you the different subsets of cubes.
//                String[] subsets = subset.split(";");
//
//                for (String s : subsets) {
//                    if (!valid) {
//                        break;
//                    }
//
//                    s = s.trim();
//
//                    // Then, get the number from the string and what color it is (I think split it by " "?)
//                    String[] colors = s.split(",");
//                    for (String c : colors) {
//                        String[] vals = c.trim().split(" ");
//                        int num = Integer.parseInt(vals[0].trim());
//                        String color = vals[1].trim();
//
//                        // If the number is greater than 12, 13, or 14 based on its color, it is impossible, so skip over it.
//                        switch (color) {
//                            case "green" -> {
//                                if (num > GREEN_LIMIT) {
//                                    valid = false;
//                                }
//                            }
//                            case "red" -> {
//                                if (num > RED_LIMIT) {
//                                    valid = false;
//                                }
//                            }
//                            case "blue" -> {
//                                if (num > BLUE_LIMIT) {
//                                    valid = false;
//                                }
//                            }
//                        }
//                    }
//                }
//
//                // Otherwise, if all parts of the subset are valid, add the id to the running total.
//                if (valid) {
//                    total_value += id_val;
//                }
//
//                // Increment line counter.
//                id_val++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Sum of valid game ids: " + total_value);
//    }

    // ----------------------------------------------------PART TWO----------------------------------------------------
    public static void main(String[] args) {
        // What is the fewest number of cubes of each color that could have been in the bag for each game?
        // The power of a game is the number of red, green, and blue cubes multiplied together.
        // Return the sum of the power of the games.
        int total_value = 0;
        int id_val = 1;
        String file_path = "/Users/rileywoolf/school/2023/cs393/advent_of_code/src/main/dec2.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            // Get a line from the file.
            while ((line = br.readLine()) != null) {
                // The ans from the first 2 lines: 812
//                if (id_val == 3) {
//                    break;
//                }

                // Remove/ignore the "Game XX:" part of the string.
                String subset = line.substring(line.indexOf(':') + 1);
                subset = subset.trim();

                // Split the string based on ';', that will give you the different subsets of cubes.
                String[] subsets = subset.split(";");

                int g = 1;
                int r = 1;
                int b = 1;

                for (String s : subsets) {

                    s = s.trim();

                    // Then, get the number from the string and what color it is (I think split it by " "?)
                    String[] colors = s.split(",");
                    for (String c : colors) {
                        String[] vals = c.trim().split(" ");
                        int num = Integer.parseInt(vals[0].trim());
                        String color = vals[1].trim();

                        // If the number is greater than the previous count of its color, update it.
                        switch (color) {
                            case "green" -> {
                                if (num > g) {
                                    g = num;
                                }
                            }
                            case "red" -> {
                                if (num > r) {
                                    r = num;
                                }
                            }
                            case "blue" -> {
                                if (num > b) {
                                    b = num;
                                }
                            }
                        }
                    }
                }

                // Calculate the power of that set by multiplying together the numbers, and add it to the total.
                total_value += (r * b * g);

                // Increment line counter.
                id_val++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Sum of the power of the sets: " + total_value);
    }
}
