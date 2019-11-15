package java_solution;

//Fraudulent Activity Notifications

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Fraudulent_Activity_Notifications {

	
    // Complete the activityNotifications function below.
	
    private static int findMedianTwice(int[] table, int d) {
    	
    	if(d%2 == 1) // odd 
    	{
    		int cntEmlement = 0;
    		int fIdx = d/2+1;
    		for(int i =0; i < table.length ; i++)
    		{
    			
    			cntEmlement += table[i]; 
    			
    			if(cntEmlement >= fIdx)
    			{
    				return (i*2); 
    			}
    		}
    		
    	}
    	else
    	{
    		int cntEmlement = 0;
    		int fIdx = d/2;
    		for(int i =0; i < table.length ; i++)
    		{
    			cntEmlement += table[i]; 
    			
    			if(cntEmlement > fIdx)
    			{
    				return (i + i);
    			}
    			else if(cntEmlement == fIdx)
    			{
    				return (i+ i+1);
    			}
    		}
    		
    	}
	
		return 0;
	}
    
    static int activityNotifications(int[] expenditure, int d) {

    	int notiCount = 0;
    	// 문제 조건에서 값의 범위가 0 부터 200 이므로 counting 정렬을 사용 
    	int []table = new int[201];
    	
    	for(int i = 0; i < 200; i++)
    	{
    		table[i] = 0;
    	}
    	
    	int medianTwice = 0;
    	int delIdx =0;
    	
    	for( int i = 0; i < expenditure.length; i++)
    	{
    		
    		if ( i < d)
    		{
    			table[expenditure[i]] += 1;
    			continue;
    		}
    		
    		medianTwice = findMedianTwice(table,d);
    		
    		//System.out.println("medianTwice = "+ medianTwice);
    		
    		if(expenditure[i] >= medianTwice )
    		{
    			notiCount+=1;
    		}
    		table[expenditure[delIdx]] -= 1; 
    		delIdx+=1;
    		table[expenditure[i]] += 1;
    		
    	}
    	
    	return notiCount;
    }



	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
