package java_solution;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution_NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int sumBribes = 0;
        for (int i = q.length-1; i > 0; i--)
        {
            
            int swap = 0;
            int before = 0;
            if(q[i] == i+1)
            {
                continue;
            }
            for(int j = 0; j < i ; j++)
            {
                
                if( q[j] > q[j+1])
                {
                    if(before == q[j])
                    {
                        swap +=1;
                    }
                    else 
                    {
                        swap = 1; 
                    }
                    int tmp = q[j] ;
                    q[j] = q[j+1];
                    q[j+1] = tmp;
                    sumBribes +=1;
                    
                    before = q[j+1];
                }
                
                if(swap > 2) 
                {
                    System.out.println("Too chaotic");
                    return ;
                
                }
                
            }
        }
        
        
        System.out.println(sumBribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

