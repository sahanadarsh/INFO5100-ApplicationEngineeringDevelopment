package Assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NumOfLinesInFiles {

	public static void main(String[] args) throws IOException{
		if(args.length == 0) {
			System.out.println("Invalid input");
			return;
		}
		File file = null;
		BufferedReader bufferReader = null;
		for(int i = 0; i < args.length; i++)
		{
			int count=0;
			try {
				file = new File(args[i]);
				bufferReader = new BufferedReader(new FileReader(file));
				try {
					String line = bufferReader.readLine();
					while(line != null) {
						count++;
						line = bufferReader.readLine();
					}
					System.out.println("File Name: " + file.getName() + " -> Total number of Lines: " + count);
				} 
				catch(IOException e){
					System.out.println("Exception : " + e);
				} 	
			} 
			catch(FileNotFoundException e){
				System.out.println("File Not Found");
			}

		}  
	}
}

