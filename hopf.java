// Login name: ak750
// Last name: Krishna-Prasad
// First name: Arjun

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


// class to implement simulation of a Hopfield neural network
public class hopf {

	public static void main(String[] args) {
		
		ArrayList<double[]> stored = new ArrayList<>(), corrupted = new ArrayList<>();		
		BufferedReader br1 = null, br2=null;
		
		// the below codes have been referenced from : https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
		// reads the stored file and converts the pattern neurons to double values.
		try {
			
			String line1, line2;
			br1 = new BufferedReader(new FileReader(args[0]));	
			br2 = new BufferedReader(new FileReader(args[1]));

			while ((line1 = br1.readLine()) != null) {
				line1 = line1.trim();				
				String[] temp = line1.split(" ");
				double[] results = new double[temp.length];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = temp[i].replaceAll("\\s","");
					results[i] = Double.parseDouble(temp[i]);
				}
				stored.add(results);
			}
			

			while ((line2 = br2.readLine()) != null) {
				line2 = line2.trim();				
				String[] temp = line2.split(" ");
				double[] results = new double[temp.length];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = temp[i].replaceAll("\\s","");
					results[i] = Double.parseDouble(temp[i]);
				}
				corrupted.add(results);
			}
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		} 
		
		finally {

			try {
				if (br1 != null)
					br1.close();

				if (br2 != null)
					br2.close();
			} 
			
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		new Implement(stored, corrupted); 	
	}
}
