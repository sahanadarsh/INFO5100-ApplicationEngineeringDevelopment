package Assignment3;

import java.util.HashSet;

public class ZigzagPattern {

	public static void main(String[] args) {
		String ip = "PAYPALISHIRING";
		System.out.println(convert(ip,4));
	}

	public static String convert(String s, int numRows) {

		//Checking error case
		if(numRows == 0) {
			System.out.println("Invalid numRows");
			return null;
		}

		//Checking base case
		if(numRows == 1) {
			return s;
		}
		int length = s.length();
		int numColumns = length / 2 + (numRows - 1);
		boolean breakFlag = false;
		String out = "";	

		//Matrix to save string in zigzag pattern
		char zzMatrix[][] = new char[numRows][numColumns];

		//Hashset to save only valid matrix entries
		HashSet<String> initSet = new HashSet<String>();

		int index = 0;
		for(int iterColumn = 0; iterColumn < numColumns;) {
			int iterRows = numRows -1;
			for(int j = 0; j < numRows; j++) {
				if (index == length) {
					breakFlag = true;
					break;
				}
				zzMatrix[j][iterColumn] = s.charAt(index);
				initSet.add(""+j+iterColumn);
				index++;
			}
			if(breakFlag) {
				break;
			}
			iterRows --;

			iterColumn++;
			while(iterRows > 0) {
				if (index == length) {
					breakFlag = true;
					break;
				}
				zzMatrix[iterRows][iterColumn] = s.charAt(index);
				initSet.add(""+iterRows+iterColumn);
				index++;
				iterRows--;
				iterColumn++;
			}

			if(breakFlag) {
				break;
			}
		}

		//get matrix entries row by row
		for (int i = 0; i < numRows; i++) {
			for(int j = 0; j < numColumns; j++) {
				if(initSet.contains(""+i+j)) {
					out = out + zzMatrix[i][j];					
				}
			}
		}
		return out;
	}
}
