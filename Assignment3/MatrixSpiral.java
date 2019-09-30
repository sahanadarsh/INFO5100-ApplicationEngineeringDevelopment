package Assignment3;

public class MatrixSpiral {

	public static void main(String[] args) {
		int[][] inputMatrix = { {1,1,1}, 
				                {2,2,2},
				                {3,3,3} };
		int[] outputArr = spiralOrder(inputMatrix);
		for(int i = 0; i < outputArr.length; i++) {
			System.out.print(outputArr[i] + " ");
		}
	}

	public static int[] spiralOrder(int[][] matrix) {

		//Handling error case
		if( matrix == null || matrix.length == 0 ) {
			System.out.println("Invalid input");
			return new int[] {};
		}

		int rowStartIndex = 0;
		int columnStartIndex = 0;

		//Array to store spiral output
		int[] spiralArray = new int[matrix.length * matrix[0].length];
		int spiralArrIdx = 0;

		int rowLength = matrix.length - 1;
		int columnLength = matrix[0].length - 1;

		//Iterate until all entries are added
		while( spiralArrIdx < matrix.length * matrix[0].length){

			//Adding row entries from left to right
			for(int i = rowStartIndex; i <= columnLength; i++){
				spiralArray[spiralArrIdx] = matrix[columnStartIndex][i];
				spiralArrIdx++;
			}
			columnStartIndex++;

			//Adding column entries from top to bottom 
			for(int j = columnStartIndex; j <= rowLength; j++){
				spiralArray[spiralArrIdx] = matrix[j][columnLength];
				spiralArrIdx++;
			}
			columnLength--;

			if(rowLength < columnStartIndex)
				break;

			//Adding row entries from right to left
			for(int k = columnLength; k >= rowStartIndex; k--){
				spiralArray[spiralArrIdx] = matrix[rowLength][k];
				spiralArrIdx++;
			}
			rowLength--;

			if(columnLength < rowStartIndex)
				break;

			//Adding column entries from bottom to top
			for(int l = rowLength; l >= columnStartIndex; l--){
				spiralArray[spiralArrIdx] = matrix[l][rowStartIndex];
				spiralArrIdx++;
			}
			rowStartIndex++;
		}
		return spiralArray;
	}
}


