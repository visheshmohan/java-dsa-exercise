package simple.DSA.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class EvenOddArrangement 
{
	int num;
	
	
	//[1,2,3,4, ,5,6,7,8,9]
	
	//[2,4,6,8,1,3,5,7,9]
	
	//
	
	/*public int add(int x)
	{
		
	}
	
	public void add(int x)
	{
		
	}
    public static void main( String[] args )
    {
    	List<String> items = new ArrayList<String>();
//    	items.add(1, "Pen"); -- IndexOutOfBoundException
    	items.add(0, "Pen");
    	items.add(1, "Pencil");
    	items.add(2, "Paper");
    	items.add("Eraser");
    	for(String oneitem : items)
        System.out.println(oneitem + " " );
    }*/
	
	public static void main(String[] args) {
		List<Integer> intr = new ArrayList<Integer>(10);
		int evenCount =0, oddCount=0;
		
		intr.add(1);
		intr.add(2);
		intr.add(3);
		intr.add(4);
		intr.add(5);
		intr.add(6);
		intr.add(7);
		intr.add(8);
		intr.add(9);
		for(Integer pr : intr)
		System.out.print(pr);
		System.out.println();
		for(int i : intr) //10
		{
			if(i%2==0) {
				evenCount++;//3
			}else
			{
				oddCount++;//7
			}
		}
		
		int checkOddPosition = evenCount; //2nd - 9th
		
		System.out.println("Evens ["+ evenCount +"]0-"+(evenCount-1)+" Odds ["+ oddCount +"]"+checkOddPosition+"-"+intr.size()+" ");
		System.out.println("Odd Starts from "+checkOddPosition+ "th position");
		
		for(int index = 0; index < intr.size();index++)
		{
			System.out.println("Check Odd Integer at "+ index);
			if(evenCount > 0)
			{
				evenCount--;
				
				if(intr.get(index)%2 == 0)
				{
					continue;
				}
				
				for(int x=checkOddPosition;x<intr.size();x++)
				{
					checkOddPosition++;
					if(intr.get(x)%2 == 0)
					{
						System.out.println("Replace "+intr.get(index) +" from ["+index+"] "
								+ "with "+ intr.get(x) +"["+x+"]");
						int temp = intr.get(x);
						intr.set(x, intr.get(index));
						intr.set(index, temp);
						break;
					}
				}
			}
		}
		for(Integer pr : intr)
			System.out.print(pr);
		
		/* 
		//Approach: assume 50-50 odd and even
		 * 
		int mid = intr.size()/2;
		//8-->4 --> 2,4,6,8,1,3,5,7
		// 9-->4 --> 2,4,6,8,1,3,5,7,9
		 * 
		//pick one number , check odd even, push to mid if odd, leave it there if even , only traverse till mid
		for(int x=0; x<mid; x++) 
		{
			Integer holdValue = intr.get(x);//holdValue=1
			if(mid >= (x+1)) //check index reached middle
			{
				System.out.println("holdValue = "+holdValue);
				System.out.println("holdValue % 2 = "+ (holdValue % 2));
				if(holdValue % 2 != 0)//even
				{
					//shift odd number to mid+1
					//iterate from x till m and shift elements
					for(int y = x+1; y<=mid;y++) {
						System.out.println("intr.get("+ (y-1)+") = "+intr.get(x));
						intr.set(y-1, intr.get(y));//shift to make space
						System.out.println("intr.get(y) = "+intr.get(x));
					}
					intr.set(x, holdValue);
				}
				System.out.println("index = "+x);
			}
			for(Integer pr : intr)
				System.out.print(pr);
			System.out.println();
		}
		//1st Cycle --> _,2,3,4,5,1,6,7,8,9
		 */
		 
		
	}
}
