package Assignment4;

public class MultiplicationOfTwoMatrices {

	public static void main(String[] args) {
		int[][] matrix1 = { {1,0,0}, 
				            {-1,0,3} };
		int[][] matrix2 = { {7,0,0}, 
				            {0,0,0},
				            {0,0,1} };
		int[][] output = twoMatricesMultiplication(matrix1, matrix2);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] twoMatricesMultiplication(int[][] matrix1,int[][] matrix2) {
		
		//matrix1.length gives the number of rows in matrix1
		//matrix1[0].length gives the number of columns in matrix1
		//matrix2.length gives the number of rows in matrix2
		//matrix2[0].length gives the number of columns in matrix2 
		
		if ( matrix1[0].length != matrix2.length ) {
			throw new IllegalArgumentException("matrix1 column is not equal to matrix2 row");
		}
		
		int[][] resMatrix = new int[matrix1.length][matrix2[0].length];
		for(int i = 0; i < matrix1.length; i++) {
			for(int j = 0; j < matrix2[0].length; j++) {
			  for(int k = 0; k < matrix1[0].length; k++) {
				 resMatrix[i][j] = resMatrix[i][j] + matrix1[i][k] * matrix2[k][j]; 
			  }
			}
		}
		return resMatrix;
	}
 }
