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
 *  Alternating Characters
 */
public class Alternating_Characters {

    /**
     * Alternating characters int.
     *
     * @param s the s
     * @return the int
     */
// Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        char checkChar = s.charAt(0);
        int delCnt = 0;

        char []chars = s.toCharArray();

        for(int i = 1; i < chars.length; i++ ) {
            if (chars[i] == checkChar) {
                delCnt += 1;
            } else {
                checkChar = chars[i];
            }
        }

        return  delCnt;

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

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
