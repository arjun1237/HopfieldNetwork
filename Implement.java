// Login name: ak750
// Last name: Krishna-Prasad
// First name: Arjun

import java.util.ArrayList;
import java.util.Arrays;


// class accepts the stored and corrupted patterns and checks if the
// corrupted patterns can be stabilized. If so, then it updates the corrupted 
// patterns until it stabilizes. 
public class Implement {
    
    private ArrayList<double[]> stored;  // stored patterns
    private ArrayList<double[]> corrupted; // corrupted patterns
    private ArrayList<double[][]> weightMatrix; // all the individual weights of stored patterns calculated
    private double learnability; // stores value to check learnability
    private int patternSize; // number of patterns by number of nuerons within each pattern
    private int neurons; // size of each pattern
    private double[][] cumulativeWeight; // stores the added weights of all the stored pattern
    
    public Implement(ArrayList<double[]> stored, ArrayList<double[]> corrupted){
         this.stored = stored;
         this.corrupted = corrupted;
         weightMatrix = new ArrayList<>();
         patternSize = stored.size();
         neurons = stored.get(0).length;
         cumulativeWeight = new double[neurons][neurons];
         continueProgram();
    }
    
    // method checks the learnable nature of stored patterns. If stable, runs start() method.
    private void continueProgram(){
        double n = stored.size();
        double i = stored.get(0).length;
        learnability = (double) (n/i);
    	if(learnability <= 0.138 || patternSize == 1)
    		start();
    	else
    		System.out.println("0");
    }
    
    // method to update corrupted pattern for all stored patterns and stores them in an arrayList.
    private void start(){        
        
        // loop calculates the weight matrix
        for(double[] temp: stored){
            int len = temp.length;
            double weiMat[][] = new double[len][len];
            
            for(int i=0; i<weiMat.length; i++){
                for(int j=0; j<weiMat.length; j++){
                    if(i==j)
                        weiMat[i][j] = 0;
                    else{
                        weiMat[i][j] = temp[i]*temp[j];
                    }
                }
            }
            weightMatrix.add(weiMat);
        }
        
        // loop calculates the cumulative weight of all stored patterns and divides it by the no of stored patterns.
        for(int i=0; i<cumulativeWeight.length; i++){
            for(int j=0; j<cumulativeWeight.length; j++){
                cumulativeWeight[i][j] = 0;
                for(double[][] temp: weightMatrix){
                    cumulativeWeight[i][j] += temp[i][j];
                }
                cumulativeWeight[i][j] = cumulativeWeight[i][j]/patternSize;
            }
        }
        update();
        
    }
    
    // checks corrupted patterns stability by repeat updation and prints the stable result.
    private void update(){   
        for(double[] corrupt: corrupted){
			double[] corruptCopy = copy(corrupt);
            boolean ch = true;
            while(ch){
                double[] currentUpdate = new double[neurons];
				
				// asynchronous updation
	            for(int i=0; i<corruptCopy.length; i++){
	                double add = 0;
	                for(int j=0; j<corruptCopy.length; j++){
	                    add = add + (corruptCopy[j] * cumulativeWeight[i][j]);
	                }
	                currentUpdate[i] = sign(add);
	                corruptCopy[i] = sign(add);
	            }
	            
	            // compares the current update with previous update
	            // and prints the pattern if true
	            if(Arrays.equals(currentUpdate, corrupt)){
	            	for(int i=0; i<neurons; i++){
	            		System.out.print((int)currentUpdate[i]+" ");
	            	}
	            	System.out.println();
	            	ch = false;
	            }	            
	            else
	            	corrupt = copy(currentUpdate);
            }
        }
    }
    
    //makes a copy of array and returns the same
    private double[] copy(double[] temp){
    	double[] temp2= new double[neurons];
    	for(int i=0; i<neurons; i++){
    		temp2[i] = temp[i];
    	}
    	return temp2;
    }
    
    // if the cumulative weight is more than or equal to 0, it updates the nueron to 1
    // if the cumulative weigth is less than 0, it updates the nueron to -1
	private double sign(double temp){
		if(temp>=0)
			return 1;
		else
			return -1;
	}
}
