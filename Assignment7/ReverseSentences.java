package Assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*Write a program that read sentences from a file and reverse sentences word by word.
  After reverse, create a new file to save sentences. (Extreme corner case is not 
  mandatory.)

Example:
Input file: the sky is blue.
Output file: blue is sky the.*/


public class ReverseSentences {

	public static void main(String[] args) throws Exception {
		//      reads from the file name called 'input.txt' in the current directory
		//      File file = new File("input.txt");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the absolute path of the file name where you want to read");
		String fileName = scanner.nextLine();
		scanner.close();
		File file = new File(fileName);
		System.out.println("File path is " + file.getCanonicalPath());
		if(file.exists() == false) {
			System.out.println(file + " not found");
			return;
		}
		File anotherFile = new File("reverse.txt");
		FileOutputStream fos = new FileOutputStream(anotherFile);
		BufferedReader reader;
		int count = 0;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			System.out.println("------Input file text------");
			while (line != null) {
				StringBuilder sb = new StringBuilder();
				System.out.println(line);
				String[] arr = line.split("\\.");
				if (count !=0) {
					sb.append("\r\n");
				}
				boolean periodAtEnd = false;
				int numChars = 0;
				for(int i = 0; i < arr.length; i++) {
					numChars = numChars + arr[i].length();
				}
				if (line.length() == numChars + arr.length) {
					periodAtEnd = true;
				}
				count++;
				for(int i = 0; i < arr.length; i++) {
					if( i != 0) {
						sb.append(" ");
					}
					if(arr[i].contains(" ")) {
						arr[i] = arr[i].strip();
					}
					sb.append(reverse(arr[i]));
					if(i == (arr.length - 1)) {
						if (periodAtEnd) {
							sb.append(".");							
						}
					} else {
						sb.append(".");
					}
				}					
				fos.write(sb.toString().getBytes());
				line = reader.readLine();
			}			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		fos.close();
	}

	public static String reverse(String s) {

		//Handling error case
		if(s.length() == 0) {
			System.out.println("No input");
			return null;
		}

		//Split into sub strings
		String[] stringArr = s.split(" ");
		int start = 0;
		int end = stringArr.length - 1;
		String temp = null;

		//Reversing the array of strings
		while(start<end) {
			temp = stringArr[start];
			stringArr[start] = stringArr[end];
			stringArr[end] = temp;
			start++;
			end--;
		}
		String output = "";

		//Generate output by adding space
		for(int i = 0; i < stringArr.length; i++) {
			output = output + stringArr[i];
			if(!(i == stringArr.length -1))
				output = output + " ";
		}
		return output;
	}

}
