package Assignment5;

@SuppressWarnings("serial")
public class MyIndexOutOfBoundException extends Exception{

	private int lowerBound;
	private int upperBound;
	private int index;

	public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.index = index;
	}

	public static void main(String[] args) throws MyIndexOutOfBoundException {
		int lowerBound = 0;
		int upperBound = 10;

		try {
			int a = getRandomNumber(100);
			if( a < lowerBound || a > upperBound) {
				throw new MyIndexOutOfBoundException(lowerBound, upperBound, a );
			}else {
				System.out.println("Working Message: Index: " + a + ", Lower bound: " + lowerBound + ", Upper bound: " + upperBound );
			}
		} catch ( Exception e) {
			System.out.println(e.toString());
		}

//		int[] arr = {1,2,3,4,5,6,7};
//		for(int i = 0; i <= arr.length; i++) {
//			try {
//				if(i >= arr.length) {
//					throw new MyIndexOutOfBoundException(0,(arr.length - 1), i);
//				} else {
//					System.out.println("Working Message: Index: " + i + ", Lower bound: " + "0" + ", Upper bound: " + (arr.length - 1) );
//				}
//			} catch ( Exception e) {
//				System.out.println(e.toString());
//			}
//		}
	}


	public String toString() {
		return "Error Message: Index: " + index + ", but Lower bound: " + lowerBound + ", Upper bound: " + upperBound ; 
	}

	public static int getRandomNumber(int x) {
		return (int) (Math.random() * x);
	}

}
