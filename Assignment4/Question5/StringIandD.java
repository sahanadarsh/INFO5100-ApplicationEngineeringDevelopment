package Assignment4;

public class StringIandD {

	public static int[] increaseOrDecrease(String s) {
		int N = s.length();
		int[] result = new int[(N + 1)];
		int low = 0;
		int high = N;
		if(s.length() < 1 && s.length() > 10000 ) {
			System.out.println("Invalid inputs");
			throw new IllegalArgumentException("Invalid inputs");
		}

		for(int i = 0; i < N;i++ ) {
			if(s.charAt(i) == 'I') {
				result[i] = low++;
			}else if(s.charAt(i) == 'D'){
				result[i] = high--; 
			}else {
				throw new IllegalArgumentException("Invalid inputs");
			}
		}
		result[N] = low;
		return result;
	}

	public static void main(String[] args) {
		String s = "IDID";
		int[] A = increaseOrDecrease(s);
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}

