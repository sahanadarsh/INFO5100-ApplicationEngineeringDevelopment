package Assignment7;

/*Write a program that decode a file. Given an encoded file, create its decoded file. The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

Assume that the string from input file is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
Examples:
Input file: "3[a]2[bc]", output file: "aaabcbc".
Input file: "3[a2[c]]", output file: "accaccacc".
Input file: "2[abc]3[cd]ef", output file: "abcabccdcdcdef".*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) throws IOException {

		//   Reads from the Encoded file name called 'EncodedFile.txt' in the current directory
		//   File file = new File("EncodedFile.txt");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the absolute path of encoded file ");
		String fileName = scanner.nextLine();
		scanner.close();
		File file = new File(fileName);
		System.out.println("File path is " + file.getCanonicalPath());
		if(file.exists() == false) {
			System.out.println(file + " not found");
			return;
		}
		FileInputStream fis = new FileInputStream(file);
		String s = readFromStream(fis);
		System.out.println("Encoded file string: " + s);
		s = decodeString(s);
		File anotherFile = new File("DecodedFile.txt");
		FileOutputStream fos = new FileOutputStream(anotherFile);
		String data = s;
		System.out.println("Decoded file string: " + s);
		fos.write(data.getBytes());
		fos.close();
	}

	private static String readFromStream(FileInputStream fis) throws IOException {
		StringBuilder sb = new StringBuilder();
		while (true) {
			int x = fis.read();
			if (x == -1)
				break;
			char c = (char) x;
			sb.append(c);
		}
		fis.close();
		return sb.toString();
	}

	public static String decodeString(String s){
		char[] arr = s.toCharArray();
		Stack<String> st = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			String str = String.valueOf(arr[i]);
			if(!str.equals("]")) {
				if(Character.isDigit(Integer.valueOf(arr[i]))){
					StringBuilder sb = new StringBuilder();
					while(Character.isDigit(Integer.valueOf(arr[i])))	{
						sb.append(arr[i]);
						i++;
						if(i >= arr.length) {
							break;
						}
					}
					i = i-1;
					str = sb.toString();
				}
				st.push(str);
			}else {
				ArrayList<String> list = new ArrayList<>();
				while(!st.peek().equals("[")) {
					list.add(st.pop());
				}
				Collections.reverse(list);
				String strng = "";
				for(int j = 0; j < list.size(); j++) {
					strng = strng + list.get(j);
				}
				st.pop();
				int n = Integer.valueOf(st.pop());
				StringBuilder sb = new StringBuilder();
				while(n > 0) {
					sb.append(strng);
					n--;
				}
				st.push(sb.toString());
			}
		}
		StringBuilder strb = new StringBuilder();
		for(int i = 0; i < st.size(); i++) {
			strb.append(st.get(i));
		}	
		return strb.toString();
	}
}
