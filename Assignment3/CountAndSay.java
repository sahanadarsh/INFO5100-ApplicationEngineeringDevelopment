package Assignment3;

public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(10));
	}

	public static String countAndSay(int n) {

		//checking input range
		if(n >= 1 && n <= 30) {
			String outString = "1";
			for (int i = 1; i < n; i++) {
				outString = getNextString(outString);
			}
			return outString;
		}else {
			System.out.println("n is not in range");
			return null;
		}
	}

	//generating next string from current string
	private static String getNextString(String outString) {
		String out = "";
		for(int i = 0; i < outString.length();) {
			int j = i + 1;
			int count = 1;
			while((j < outString.length()) && outString.charAt(i) == outString.charAt(j)) {
				count++;
				j++;
			}
			out = out + count + outString.charAt(i);
			i=j;
		}
		return out;
	}
}
