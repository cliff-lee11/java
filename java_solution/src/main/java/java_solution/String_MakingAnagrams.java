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
 * Strings: Making Anagrams
 */
public class String_MakingAnagrams {

    /**
     * Make anagram int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
// Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        int[] tableA = new int[26];
        int[] tableB = new int[26];

        for(int i=0 ; i < tableA.length; i++)
        {
            tableA[0] = 0;
        }
        System.arraycopy(tableA,0,tableB,0,tableA.length);

        for( Character c : a.toCharArray()) {
            tableA[c - 'a'] += 1;
        }

        for( Character c : b.toCharArray()){
            tableB[c-'a'] +=1;
        }

        int removeCharCnt = 0;
        for( int i =0; i < 26; i++)
        {
            if(tableA[i]  == tableB[i] )
            {
                continue;
            }
            else
            {
                removeCharCnt += Math.abs(tableA[i] - tableB[i]);
            }
        }

        return removeCharCnt;

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

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
