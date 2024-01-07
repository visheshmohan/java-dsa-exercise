package simple.DSA.project;

import java.io.*;
import java.util.*;

/*
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.concurrent.*;
import java.util.regex.*;
*/


/**
 * HackerLand University has the following grading policy:<br>
<br>
Every student receives a  in the inclusive range from 0 to 100.<br>
Any grade less than 40 is a failing grade.<br>
Sam is a professor at the university and likes to round each student's grade according to these rules:<br>
<br>
If the difference between the grade and the next multiple of 5 is less than 3, round  up to the next multiple of 5.<br>
If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.<br>
Examples<br>
<br>
 grade = 84 round to  85(85 - 84 is less than 3)<br>
 grade = 29 do not round (result is less than 40)<br>
 grade = 57 do not round (60 - 57 is 3 or higher)<br>
Given the initial value of grade for each of Sam's n students, write code to automate the rounding process.<br>
HR Link[https://www.hackerrank.com/challenges/grading/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign]
 * 
 * 
 * @author HackerRank
 *
 */
public class ClimbingLeaderboard 
{
    public static void main(String[] args) throws IOException 
    {
    	//String dir = "src/test/resources/";

    	String dir = "data/";
    	//String file = dir + "climbleaderboard.txt";
    	String file = dir + "climbleaderboard1.txt";
    	
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ranked = new ArrayList<Integer>();

        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
            System.out.print(rankedItem + " ");
        }
        System.out.println();

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> player = new ArrayList<Integer>();

        for (int i = 0; i < playerCount; i++) {
            int playerItem = Integer.parseInt(playerTemp[i]);
            player.add(playerItem);
            System.out.print(playerItem + " ");
        }
        System.out.println();

        //List<Integer> result = climbingLeaderboard(ranked, player);
        List<Integer> result = climbingLeaderboardInSequence(ranked, player);

        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
        	System.out.println(result.get(i)+" ");
        }
        //System.out.println("]");

        bufferedReader.close();
        //bufferedWriter.close();
    }
    
    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboardInSequence(List<Integer> ranked, List<Integer> player) 
    {
    	// Write your code here
        List<Integer> rankedboard = new ArrayList<Integer>();
        List<Integer> newboard = new ArrayList<Integer>(player.size());
        int rank = 1;
        
        for (int x =0 ;x<player.size();x++) 
        {
            newboard.add(0);
        }
        
        rankedboard.add(rank);
        System.out.print(rank+ " ");
        for (int x =1 ;x<ranked.size();x++) //Dense Ranking
        {
            if(ranked.get(x) < ranked.get(x-1))
            {
                rank +=1;
            }
            rankedboard.add(rank);
            System.out.print(rank + " ");
        }
        System.out.println("<-- rankedboard");
        System.out.println();
        
        for(int index= 0 ;index <player.size() ; index++)
        {
        	boolean rankdone = false;
        	System.out.print(player.get(index) +" from ");
        	
            for( int x = 0;x<ranked.size();x++) // compare with rankedboard from top
            {
            	System.out.print(ranked.get(x) +" ");
               
                rank = rankedboard.get(x);
                if(player.get(index) == ranked.get(x))
                {
                	System.out.print(" rank is " + rank + "\n");
                	newboard.set(index,rank);
                    rankdone = true;
                    //System.out.println(" Same Rank");
                    break;
                	
                }
                else if(player.get(index)>ranked.get(x))
                {
                	System.out.print(" rank is " + rank + "\n");
                	newboard.set(index,rank);
                    //System.out.println(" Better Rank");
                    rankdone = true;
                    
                    break;
                    
                }
                else 
                {
                    //System.out.println(" more Rank");
                    continue;
                }
                
            }
            if(!rankdone)
            {
            	rank += 1;
            	newboard.set(index, rank);
            	System.out.print(" rank is " + rank + "\n");
            }
            printboard(newboard , "newboard");
        }
        printboard(rankedboard , "rankedboard");
        printboard(ranked , "ranked");
        printboard(player , "player");
        return newboard;
    }
    
    private static void printboard(List<Integer> board, String boardName)
    {
    	System.out.println();
    	 for (int i = 0; i < board.size(); i++) 
         {
             System.out.print(board.get(i) + " ");
         }
         System.out.println("<-- "+boardName+" updated");
    }
    
    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) 
    {
    	// Write your code here
        List<Integer> rankedboard = new ArrayList<Integer>();
        List<Integer> newboard = new ArrayList<Integer>(player.size());
        int rank = 1;
        
        for (int x =0 ;x<player.size();x++) 
        {
            newboard.add(0);
        }
        
        rankedboard.add(rank);
        System.out.print(rank+ " ");
        for (int x =1 ;x<ranked.size();x++) 
        {
            if(ranked.get(x) < ranked.get(x-1))
            {
                rank +=1;
            }
            rankedboard.add(rank);
            System.out.print(rank + " ");
        }
        System.out.println("<-- rankedboard");
       
        
        System.out.println();
        int x =0 ;
        for(int index=player.size()-1;index > -1; index--)
        {
        	boolean rankdone = false;
        	System.out.print(player.get(index) +" from ");
        	rank = rankedboard.get(0);
        	
            for( ;x<ranked.size();x++) // compare with rankedboard from top
            {
            	System.out.print("\n"+ranked.get(x) +" is");
               
                rank = rankedboard.get(x);
                if(player.get(index) == ranked.get(x))
                {
                	newboard.set(index,rank);
                    rankdone = true;
                    System.out.println(" Same Rank");
                    break;
                	
                }
                else if(player.get(index)>ranked.get(x))
                {
                	newboard.set(index,rank);
                    System.out.println(" Better Rank");
                    
                    for(int j = x; j < rankedboard.size(); j++) // plus one to rank from x position
                    {
                        int updatedRank = rankedboard.get(j)+1;
                        rankedboard.set(j,updatedRank);
                    }
                    rankdone = true;
                    for (int i = 0; i < ranked.size(); i++) 
                    {
                        
                        System.out.print(rankedboard.get(i) + " ");
                    }
                    System.out.println("<-- rankedboard updated");
                    break;
                    
                }
                else 
                {
                    System.out.println(" more Rank");
                    continue;
                }
                
                
                
            }
            if(!rankdone)
            {
            	rank += 1;
            	newboard.set(index, rank);
            }
        }
        for(int index=0;index < rankedboard.size();index++)
        {
        	System.out.print(rankedboard.get(index)+" ");
        }
        System.out.println();
        for(int index=0;index < ranked.size();index++)
        {
        	System.out.print(ranked.get(index)+" ");
        }
        System.out.println();
        for(int index=0;index < player.size();index++)
        {
        	System.out.print(player.get(index)+" ");
        }
        System.out.println();
        return newboard;
    }
    
    
}
