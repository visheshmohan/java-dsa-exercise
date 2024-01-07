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
public class GradingStudents 
{
    public static void main(String[] args) throws IOException 
    {
    	//String dir = "src/test/resources/";

    	String dir = "data/";
    	String file = dir + "testcase10.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = new ArrayList<Integer>();

        for (int i = 0; i < gradesCount; i++) {
            int gradesItem = Integer.parseInt(bufferedReader.readLine().trim());
            grades.add(gradesItem);
        }

        List<Integer> result = gradingStudents(grades);

        for (int i = 0; i < result.size(); i++) 
        {
            //bufferedWriter.write(String.valueOf(result.get(i)));
            System.out.println(String.valueOf(result.get(i)));

            if (i != result.size() - 1) 
            {
                //bufferedWriter.write("\n");
                System.out.println();
            }
        }

        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
    
    public static List<Integer> gradingStudents(List<Integer> grades) 
    {
	    // Write your code here
	    List<Integer> finalGrades = new ArrayList<Integer>();
	    for(Integer grade : grades)
	    {
	        finalGrades.add(nextmultipleof5(grade));
	    }
	    return finalGrades;
    }
    
    private static int nextmultipleof5(int originalGrade)
    {
        if(originalGrade < 38  || originalGrade%5 == 0 || originalGrade%5 < 3  )
        {
            return originalGrade;
        }
        
        int remainder = 5-originalGrade%5 ;
        
        return originalGrade+remainder;
        
    }
}
