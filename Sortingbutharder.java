package sorting;

import java.util.Scanner;

public class Sortingbutharder 
{
	public static void main(String[] args)
	{
		int[] array;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter array size: ");
		int a_size = input.nextInt();
		array = new int[a_size];
		System.out.print("Enter " + a_size + " values: ");
		for (int i = 0; i < array.length; i++)
		{
			array[i] = input.nextInt();
		}
		System.out.println("MENU");
		System.out.println("1. Bubble Sort\n2. Insertion\n3. Selection");
		System.out.print("Select sort: ");
		int operation = input.nextInt();
		System.out.println();
		
		switch (operation)
		{
			case 1: bubbleSort(array);
					break;
			case 2: insertionSort(array);
					break;
			case 3: selectionSort(array);
					break;
		}
	}
	public static void bubbleSort(int array[]) 
	{
		int size = array.length;

		for (int i = 0; i < (size-1); i++) 
		{
			boolean swapped = false;
			for (int j = 0; j < (size-i-1); j++) 
			{
				if (array[j] > array[j + 1]) 
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
      
					swapped = true;
					
					for (int m = 0; m < size; m++)
					{
						System.out.print(array[m] + " ");
						if (m == size - 1)
							System.out.println();
					}
				}
			}
			if (!swapped)
				break;
		}
		for (int m = 0; m < size; m++)
		{
			System.out.print(array[m] + " ");
		}
	}
	public static void insertionSort(int array[]) 
	{
		int size = array.length;
	
		for (int step = 1; step < size; step++) 
		{
			int key = array[step];
			int j = step - 1;
	
			while (j >= 0 && key < array[j]) 
			{
				array[j + 1] = array[j];
				--j;
				for (int m = 0; m < size; m++)
				{
					System.out.print(array[m] + " ");
					if (m == size - 1)
						System.out.println();
				}
			}
	
			array[j + 1] = key;
		}
		for (int m = 0; m < size; m++)
		{
			System.out.print(array[m] + " ");
			if (m == size - 1)
				System.out.println();
		}
	}
	public static void selectionSort(int array[]) 
	{
		int size = array.length;

		for (int step = 0; step < size - 1; step++) 
		{
			int min_idx = step;
			for (int i = step + 1; i < size; i++) 
			{
				if (array[i] < array[min_idx]) 
				{
					min_idx = i;
				}
			}
			for (int m = 0; m < size; m++)
			{
				System.out.print(array[m] + " ");
				if (m == size - 1)
					System.out.println();
			}
			int temp = array[step];
			array[step] = array[min_idx];
			array[min_idx] = temp;
		}
		for (int m = 0; m < size; m++)
		{
			System.out.print(array[m] + " ");
			if (m == size - 1)
				System.out.println();
		}
	}
}
