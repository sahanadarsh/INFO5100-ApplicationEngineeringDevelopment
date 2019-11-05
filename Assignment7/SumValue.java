package Assignment7;

import java.util.Random;

/* Write a program that calculate the sum value in an array of ints using 4 threads.
 * You should construct an 4,000,000 long array of random numbers and return the sum of the array.
 * Please finish those two method: generateRandomArray and sum. */

public class SumValue {

	/*generate array of random numbers*/
	static void generateRandomArray(int[] arr){
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt();
		}
	}

	static long sum(int[] arr){
		int numOfThreads = 4;
		int n = arr.length;
		long sum =0;
		SumValueThread[] thread = new SumValueThread[numOfThreads];
		for(int i = 0; i < numOfThreads; i++) {
			thread[i] = new SumValueThread(arr, i*n/numOfThreads, (i+1)*n/numOfThreads);
			thread[i].start();
			try {
				thread[i].join();
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
			sum = sum + thread[i].getResult();
			System.out.println("Sum = "+sum);
		}
		return sum;
	}

	static class SumValueThread extends Thread {
		private int[] arr;
		private int start;
		private int end;
		private int result = 0;

		public SumValueThread(int[] arr,int start,int end) {
			this.arr = arr;
			this.start = start;
			this.end = end;
		}

		public void run() {
			System.out.println("Starting thread to add elements in index from "+ start +" to " + (end-1));
			for(int i = start; i < end; i++) {
				result = result + arr[i];
			}
		}

		public long getResult() {
			return this.result;
		}
	}

	public static void main(String[] args){
		int[] arr = new int[4000000];
		generateRandomArray(arr);
		long sum = sum(arr);
		System.out.println("Sum: " + sum);
	}
}
