package packageJava;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class BSCS_Cruz_Array 
{
	public static void save(double[][]info, double []average)
	{
		try 
		{
			FileWriter save = new FileWriter(path + "/" + filename);
			for (int s = 0; s < info.length; s++)
			{
				save.write("\n" + s);
				for (int q = 0; q < info.length; q++)
				{
					save.write("\t" + info [s][q]);
				}
				save.write("\t" + average[s]);
				if (average[s] > 75)
				{
					save.write("\tPassed");
				}
				else if (average[s] <= 75)
				{
					save.write("\tFailed");
				}
			}
			save.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public static void makeFile ()
	{
		File directory = new File(path);
        if (! directory.exists()){
            directory.mkdirs();
        }

        File file = new File(path + "/" + filename);
        try{
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }
	}
	public static void removeDuplicate(int values4[])
	{
		Set<Integer> st=new HashSet<>();
		int len=values4.length;
		
		for (int l=0;l<len-1;l++)
		{
			st.add(values4[l]);
		}
		
		st.forEach(elem -> System.out.print(elem+" "));
	}
	public static String filename;
	public static String path = "data";
	public static void main(String[] args) throws InterruptedException
	{
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("     _____________________");
		System.out.println("    |                       |");
		System.out.println("    |       ! MENU !        |");
		System.out.println("    |                       |");
		System.out.println("    |1. SUM OF N NUMBERS    |");
		System.out.println("    |2. MAXIMUM & MINIMUM   |");
		System.out.println("    |3. STUDENT GRADE BOOK  |");
		System.out.println("    |4. DELETE DUPLICATE    |");
		System.out.println("    |5. EXIT                |");
		System.out.println("    |_______________________|\n");
		System.out.print("Enter Choice [1-3]: ");
		int operation = sc.nextInt();							
	    switch(operation)
	    {
	    case 1:
	    System.out.print("\n================================================");
	    System.out.print("\n\nLoading");
	    Thread.sleep(1000);
	    System.out.print(" ...... Please wait");
	    Thread.sleep(1000);
	    System.out.print(" ...... Program ready!");
	    Thread.sleep(1000);
	    System.out.print("\n\n================================================");
		System.out.println("\n\n1.) SUM OF N NUMBERS IN AN ARRAY");
		System.out.println();
		System.out.print("Input array size: ");
		int size=sc.nextInt();
		int[]values=new int[size];
		System.out.print("Input "+size+" values: ");             
		for(int i=0;i<values.length;i++)
		{
			values[i]=sc.nextInt();
		}
		int sum=0;
		int lengthofarray=values.length;
		for(int i=0;i<lengthofarray;i++)
		{
			sum = sum+values[i];
		}
		System.out.println("The sum of "+size+" values: "+sum);
		System.out.println("\n!YOU HAVE BEEN RETURNED TO THE MENU!");
		break;
		
		//----------------------------------------------------------------
		
	    case 2:
	    System.out.print("\n================================================");
	    System.out.print("\n\nLoading");
	    Thread.sleep(1000);
	    System.out.print(" ...... Please wait");
	    Thread.sleep(1000);
	    System.out.print(" ...... Program ready!");
	    Thread.sleep(1000);
	    System.out.print("\n\n================================================");
	    System.out.println();
		System.out.println("\n2.) FIND THE MAXIMUM AND MINIMUM OF N NUMBERS IN AN ARRAY");
		System.out.println();
		System.out.print("Input array size: ");
		int size2=sc.nextInt();
		int[]values2=new int[size2];
		System.out.print("Input "+size2+" values: ");
		for(int j=0;j<values2.length;j++)
		{
			values2[j]=sc.nextInt();
		}
		int min=values2[0];
		int max=values2[0];
		for(int j=0;j<values2.length;j++)
		{
			if(values2[j]<min)
			{
				min=values2[j];
			}
			if(values2[j]>max)
			{
				max=values2[j];
			}
		}
		System.out.println("Maximum Value: "+max);
		System.out.println("Minimum Value: "+min);
		System.out.println("\n!YOU HAVE BEEN RETURNED TO THE MENU!");
		break;
		
		//----------------------------------------------------------------
		
	    case 3:
			filename = "Student.txt";
			makeFile();
			System.out.println("Filename of the file: " + filename);
			
			System.out.print("Number of students: ");
			int studnum = sc.nextInt();
			System.out.print("Number of quizzes: ");
			int quiznum = sc.nextInt();
			
			double[][] info = new double [studnum][quiznum];
			double[] average = new double [studnum];
			int passed = 0, failed = 0;
			
			for (int s = 0; s < studnum; s++)
			{
				System.out.print("\n");
				for (int q = 0; q < quiznum; q++)
				{
					System.out.print("Student #" + (s + 1) + " quiz " +  (q + 1) + ": ");
					info [s][q] = sc.nextDouble();
					average[s] += info[s][q];
					}
					average[s] /= quiznum;
					System.out.print("\nAverage: " + average[s]);
					if (average[s] >= 75)
					{
						System.out.println("\nPassed!");
						passed += 1;
					}
					else if (average[s] < 75)
					{
						System.out.println ("\nFailed");
						failed += 1;
				}
			}
			System.out.println("\nNumber of students passed: " + passed);
			System.out.println("Number of students failed: " + failed);
			save(info, average);    	
	    
        System.out.println("\n!YOU HAVE BEEN RETURNED TO THE MENU!");
        break;
		
		//----------------------------------------------------------------
		
	    case 4:
	    System.out.print("\n================================================");
	    System.out.print("\n\nLoading");
        Thread.sleep(1000);
        System.out.print(" ...... Please wait");
	    Thread.sleep(1000);
	    System.out.print(" ...... Program ready!");		    
	    Thread.sleep(1000);
	    System.out.print("\n\n================================================");
		System.out.println();
		System.out.println("\n4.) WRITE A PROGRAM TO DELETE DUPLICATE VALUES IN AN ARRAY");
		System.out.println();
		System.out.print("Input array size: ");
		int size4=sc.nextInt();
		int[]values4=new int[size4];
		System.out.print("Input "+size4+" values: ");
		for(int l=0;l<values4.length;l++)
		{
			values4[l]=sc.nextInt();
		}
		
		removeDuplicate(values4);
		System.out.println();
		System.out.println("\n!YOU HAVE BEEN RETURNED TO THE MENU!");
		break;
		
		//----------------------------------------------------------------
		
	    default: System.out.println("\nERROR! You have been returned to the MENU"); 			
      	break;
      	
        //----------------------------------------------------------------
      	
	    case 5: 
	    
	    System.out.print("\n================================================");
	    System.out.print("\n\nClosing Program");
        Thread.sleep(700);
	    System.out.print(" ...... ");
	    Thread.sleep(700);
	    System.out.print("Program Terminated! 🙂");		    		    
	    Thread.sleep(700);
	    System.out.println("\n\n-CRUZ, RAMOS, EDIC (Programmers)");
	    System.out.print("\n================================================");
      	return;
      	
	    }
	    
		}

	}
		
		//----------------------------------------------------------------
		
		
	
	}