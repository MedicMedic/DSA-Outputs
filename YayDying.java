package packageJava;
import java.util.*;
import java.io.*;
import java.text.*;

public class YayDying
{
	public static String pattern = "##.00";
	public static String filename;
	public static String path = "data";
	public static void main(String[] args)
	{
		Scanner input = new Scanner (System.in);
		boolean exit = true;
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		System.out.print("Enter File Name: ");
		filename = input.nextLine();
		filename += ".txt";
		makeFile();
		System.out.println("Filename of the file: " + filename);
		
		System.out.print("Number of students: ");
		int studnum = input.nextInt();
		System.out.print("Number of quizzes: ");
		int quiznum = input.nextInt();
		
		double[][] info = new double [studnum][quiznum];
		double[] average = new double [studnum];
		int passed = 0, failed = 0;
		
		for (int s = 0; s < studnum; s++)
		{
			System.out.print("\n");
			for (int q = 0; q < quiznum; q++)
			{
				System.out.print("Student #" + (s + 1) + " quiz " +  (q + 1) + ": ");
				info [s][q] = input.nextDouble();
				average[s] += info[s][q];
				}
				average[s] /= quiznum;
				System.out.print("\nAverage: " + decimalFormat.format(average[s]));
				if (average[s] > 75)
				{
					System.out.println("\nPassed!");
					passed += 1;
				}
				else if (average[s] <= 75)
				{
					System.out.println ("\nFailed :(");
					failed += 1;
			}
		}
		System.out.println("\nNumber of students passed: " + passed);
		System.out.println("Number of students failed: " + failed);
		save(info, average);
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
	public static void save(double[][]info, double []average)
	{
		try 
		{
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			FileWriter save = new FileWriter(path + "/" + filename);
			save.write("\t\t");
			for (int h = 0; h < info.length; h++)
			{
				save.write("\tQuiz " + (h+1));
			}
			save.write("\tAverage");
			save.write("\tRemarks");
			for (int s = 0; s < info.length; s++)
			{
				save.write("\nStudent #" + (s + 1));
				for (int q = 0; q < info.length; q++)
				{
					save.write("\t\t" + info [s][q]);
				}
				save.write("\t\t" + decimalFormat.format(average[s]));
				if (average[s] > 75)
				{
					save.write("\t\tPassed");
				}
				else if (average[s] <= 75)
				{
					save.write("\t\tFailed");
				}
			}
			save.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}