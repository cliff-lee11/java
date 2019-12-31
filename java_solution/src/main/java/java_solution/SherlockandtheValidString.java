package java_solution;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Solution.
 * Sherlock and the Valid String
 */
public class SherlockandtheValidString {

	/**
	 * Is valid string.
	 *
	 * @param s the s
	 * @return the string
	 */
	// Complete the isValid function below.
	static String isValid(String s) {

		HashMap<Character,Integer> refMap = new HashMap<Character,Integer>();

		for(Character c : s.toCharArray())
		{
			refMap.compute(c, (Character key, Integer value)-> (value == null)?1:value+1);

		}

		System.out.println(" REF MAP:" + refMap.toString());

		ArrayList<Integer> vList = new ArrayList<Integer>(refMap.values());


		HashMap<Integer,Integer> checkMap = new HashMap<Integer,Integer>();

		for(Integer i : vList)
		{
			checkMap.compute(i, (Integer key, Integer value)-> (value == null)?1:value+1);
		}

		System.out.println(" MAP:" + checkMap.toString());

		if(checkMap.size() > 2)
		{
			return "NO";
		}
		else if(checkMap.size()  == 1 )
		{
			return "YES";
		}
		else
		{
			System.out.println(" MAP:" + checkMap.toString());

			ArrayList<Integer> chkList = new ArrayList<Integer>(checkMap.keySet());
			Collections.sort(chkList);

			int diff = chkList.get(1) - chkList.get(0);

			if(diff == 1 && (checkMap.get(chkList.get(0)) == 1 || checkMap.get(chkList.get(1)) == 1))
			{
				return "YES";
			}
			if(checkMap.get(chkList.get(0)) == 1)
			{
				return "YES";
			}

		}
		return "NO";

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
