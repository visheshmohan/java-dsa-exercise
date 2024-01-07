package simple.DSA.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.concurrent.*;
import java.util.regex.*;
*/


public class HRChoclateGame {
    public static void main(String[] args) throws IOException 
    {
        /*
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        */

        List<Integer> arr = new ArrayList<Integer>();

        /*
        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }
        */
        
       //arr = [1,1,2,2,3];
        arr.clear();
        arr.add(1);arr.add(1);
        arr.add(2);arr.add(2);
        arr.add(3);

        int result = chocolateGame(arr);
        
        System.out.println(result);

		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedReader.close(); bufferedWriter.close();
		 */
    }
    
    public static int chocolateGame(List<Integer> arr) 
    {
	    // Write your code here
	    int winCount = 0;
	    List<List<Integer>> subsequences = formSubsequence(arr);
	    
	    for(List<Integer> sequence : subsequences)
	    {
	        int choclatesInSequence = 0;
	        for(int index=0;index < sequence.size(); index++)
	        {
	            choclatesInSequence += sequence.get(index);
	        }
	            winCount += laurelWins(choclatesInSequence)?1:0;
	    }
	    return winCount;
    }
    
    
    private static boolean laurelWins(int choclates)
    {
        boolean wins = false;
        if(choclates%2 != 0)
        {
            wins = true;
        }
        return wins;
    }
    
    private static List<List<Integer>> formSubsequence(List<Integer> arr)
    {
        List<List<Integer>> subseqList = new ArrayList<List<Integer>>();
        final int totalPiles = arr.size();
        for(int index =0 ; index < totalPiles-1 ;index++)
        {
            List<Integer> tempSequence = new ArrayList<Integer>();
            //[0,1];[0,1,2],[0,1,2,n] <-- +1
            //[0,2];[0,2,4],[0,2,4,n]<-- +2
            //[0,3] ; <-- +3 .. +n
            
            for(int indexAddition = 1; indexAddition < totalPiles; indexAddition++)
            {
                tempSequence.add(arr.get(index));
                for(int i= index+1; i < totalPiles-index; i += indexAddition)
                    {
                        tempSequence.add(arr.get(i));

                        System.out.print(" i is: "+ i);
                        System.out.print(" totalPiles-index is: "+ (totalPiles-index));
                    }
                subseqList.add(new ArrayList<Integer>(tempSequence));
            System.out.print(tempSequence);
            System.out.println(" indexAddition is: "+ indexAddition);
            tempSequence.clear();
            }
            
        }
        System.out.println(subseqList);
        return subseqList;
    }
}

