package java_solution;

//Merge Sort: Counting Inversions
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class MergeSort_Counting_Inversions {

	private static void swap(int[] arr, int high, int low) {


		System.out.println("swap " + arr[high] + "  "+ arr[low]);
		int tmp = arr[high];
		arr[high] = arr[low];
		arr[low] = tmp;

		return ;

	}
	
	private static long mergesort(int[] arr, int [] tmp, int low, int high) {

		int length = high-low ; 
		long rtn = 0;

		if(length == 1)
		{
			if(arr[high] < arr[low])
			{
				swap(arr, high,low);

				return 1; 
			}
			return 0;
		}
		else if( length == 0)
		{
			return 0;
		}

		int mid = (low + high) >>> 1;

		rtn =  mergesort(arr, tmp, low, mid) +  mergesort(arr,tmp, mid+1,high);

		// two list merge check 
		rtn += merge(arr,tmp,low,high,mid,length);

		return rtn;


	}

	private static long merge(int[] arr, int[] tmp, int low, int high, int mid,int length) {

		int leftPEnd = mid;
		int leftPStart = low;
		int rightPStart = mid+1;
		int rightPEnd = high;
		long move = 0;

		if(length <= 1)
		{
			return 0;
		}


		for(int i = leftPStart, p = leftPStart, q = rightPStart; i <= rightPEnd; i++) 
		{
			if (q > rightPEnd || (p <= leftPEnd && arr[p] <= arr[q]))
			{
				tmp[i] = arr[p++];
			}
			else
			{
				move += (q-i);
				tmp[i] = arr[q++];
			}
		}

		System.arraycopy(tmp, low, arr, low, length+1);
		return move;
	}

	// Complete the countInversions function below.
	static long countInversions(int[] arr) {

		int [] tmp = new int[arr.length];
		return mergesort(arr,tmp,0,arr.length-1);

	}
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			long result = countInversions(arr);


			for(int a : arr)
			{
				System.out.print(a+ " ");
			}
			System.out.println(": rslt");


			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
