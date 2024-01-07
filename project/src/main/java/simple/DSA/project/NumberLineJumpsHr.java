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
HR Link[https://www.hackerrank.com/challenges/kangaroo/problem]
 * 
 * 
 * @author HackerRank
 *
 */
public class NumberLineJumpsHr 
{
    public static void main(String[] args) throws IOException 
    {
    	String dir = "data/";
    	String file = dir + "numberLineJump1.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = kangaroo(x1, v1, x2, v2);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();
        System.out.println(result);

        bufferedReader.close();
        //bufferedWriter.close();
    }
    
    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) 
    {
	    if(x1 > x2 && v1 > v2)
	    {
	        return "NO";
	    }else if(x1 < x2 && v1 < v2)
	    {
	        return "NO";
	    }else if(x1 == x2 && v2 != v1)
	    {
	        return "NO";
	    }else if(x1 != x2 && v2 == v1)
	    {
	        return "NO";
	    }else if((x1+v1) ==(x2+v2))
	    {
	        return "YES";
	    }else
	    {
	        return kangaroo((x1+v1),v1,(x2+v2),v2);
	    }

    }
}
