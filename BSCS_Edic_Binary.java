package binarysearch;
import java.util.Scanner;

public class BSCS_Edic_Binary 
{
	public static void main(String args[]) 
	{
	    BinarySearch ob = new BinarySearch();
	    Scanner input = new Scanner(System.in);
	    
	    System.out.print("Enter array length: ");
	    int length = input.nextInt();
	    
	    int[] array = new int[length];
	    
	    System.out.print("Input numbers: ");
	    for (int i = 0; i < length; i++)
	    {
	    	array[i] = input.nextInt();
	    }
	    
	    System.out.print("Search: ");
	    int search = input.nextInt();
	    
	    int result = binarySearch(array, search, 0, length - 1);
	    
	    if (result == -1)
	    	System.out.println("Not found");
	    else
	    	System.out.println("Element found at index " + result);
	}
	
	static int binarySearch(int array[], int x, int low, int high) 
	{

	    if (high >= low) 
	    {
	    	int mid = low + (high - low) / 2;

	    	if (array[mid] == x)
	    		return mid;

	    	if (array[mid] > x)
	    		return binarySearch(array, x, low, mid - 1);

	    	return binarySearch(array, x, mid + 1, high);
	    }
	    return -1;
	}
}
