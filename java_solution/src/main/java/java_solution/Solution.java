package java_solution;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * The type Solution.
 * Sherlock and the Valid String
 */
public class Solution {

    /**
     * Is valid string.
     *
     * @param s the s
     * @return the string
     */
// Complete the isValid function below.
    static String isValid(String s) {


        return "";
    }

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
