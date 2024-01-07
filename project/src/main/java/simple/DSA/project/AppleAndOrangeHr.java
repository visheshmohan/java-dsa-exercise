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
public class AppleAndOrangeHr 
{
    public static void main(String[] args) throws IOException 
    {
    	//String dir = "src/test/resources/";

    	String dir = "data/";
    	String file = dir + "appleorange3.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        String[] applesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> apples = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesTemp[i]);
            apples.add(applesItem);
        }

        String[] orangesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> oranges = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesTemp[i]);
            oranges.add(orangesItem);
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
    
    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) 
    {
        // Write your code here
        List<Integer> appleFallen = findlocation(a,apples);
        List<Integer> orangeFallen = findlocation(b,oranges);
        long appleOnHouse = findFruitinHouse(appleFallen,s,t);
        System.out.println("\n\n\n Count Oranges Now \n\n");
        long orangeOnHouse = findFruitinHouse(orangeFallen,s,t);
        System.out.println(appleOnHouse +"\n"+orangeOnHouse);
    }
    
    private static List<Integer> findlocation(int a, List<Integer> apples)
    {
        List<Integer> fallenFruit = new ArrayList<Integer>();
        for(Integer apple: apples)
        {
           fallenFruit.add(apple + a);
        }
        
        return fallenFruit;
    }
    
    private static long findFruitinHouse(List<Integer> fallenFruit, int s, int t)
    {
        long onHouse = 0;
        for (Integer integer : fallenFruit) 
        {
            System.out.print("Fallen at "+ integer);
            if(integer >=s && integer <=t)
            {
            	System.out.print(" [Yes]");
                onHouse++;
            }
            System.out.println();
        }
        return onHouse;
    }
}
