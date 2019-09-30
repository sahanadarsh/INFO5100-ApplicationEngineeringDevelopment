package Assignment3;

public class ReverseStringWordByWord {

	public static void main(String[] args) {
		String input = "the sky is blue";
		System.out.println(reverse(input));
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

