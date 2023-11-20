package recursiveStringtoInt;

import java.util.Scanner;
import java.text.*;

public class RecursionStringtoInt 
{
	public static void main(String[] args)
	{
		DecimalFormat df = new DecimalFormat("###,###,###.00");
		Scanner input = new Scanner(System.in);
		System.out.print("Input numbers: ");
		String numString = input.nextLine();
		int numInt = sTOi(numString);
		System.out.println("String to Integer: " + df.format(numInt));
		System.out.println("Object type: " + ((Object)numInt).getClass().getName());
	}
	static int sTOi(String str)
    {
		DecimalFormat df = new DecimalFormat("###,###,###.00");
        if (str.length() == 1)
        {
        	
            return (str.charAt(0) - '0');
        }
 
        double y = sTOi(str.substring(1));
        System.out.println(df.format(y));
 
        double x = str.charAt(0) - '0';
        
        x = x * pow(10, str.length() - 1) + y;
        System.out.println(df.format(x));
 
        if (str.length() >= 11)
			System.out.println("Strings longer than 11 don't work as intended");
        return (int)(x);
	}
	static int pow(int base, int power)
	{
	    int result = 1;
	    while (power != 0) 
	    {
	        result = result * base;
	        power--;
	    }
	    return result;
	}
}
