package sorting;

import java.util.Scanner;

public class SortingButIDoTheGroupProjectByMyself 
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
		System.out.println("1. Merge\n2. Quick Sort\n3. Heap Sort");
		System.out.print("Select sort: ");
		int operation = input.nextInt();
		System.out.println();
		
		switch (operation)
		{
			case 1: mergeSort(array, 0, array.length - 1);
					break;
			case 2: quickSort(array, 0, array.length -1 );
					break;
			case 3: heapSort(array);
					break;
		}
	}
	public static void merge(int arr[], int p, int q, int r) 
	{
		int n1 = q - p + 1;
		int n2 = r - q;

		int L[] = new int[n1];
		int M[] = new int[n2];

		for (int i = 0; i < n1; i++)
		{	
			L[i] = arr[p + i];
			System.out.println("part1");
			for (int k = 0; k < n1; k++)
				System.out.print(L[k] + " ");
				System.out.println();
		}	
		for (int j = 0; j < n2; j++)
		{
			M[j] = arr[q + 1 + j];
			System.out.println("part2");
			for (int k = 0; k < n2; k++)
				System.out.print(M[k] + " ");
				System.out.println();
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = p;

		while (i < n1 && j < n2) 
		{
			if (L[i] <= M[j]) 
			{
				arr[k] = L[i];
				i++;
			} 
			else 
			{
				arr[k] = M[j];
				j++;
			}
			k++;
		}

		while (i < n1) 
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) 
		{
			arr[k] = M[j];
			j++;
			k++;
		}
	}
	public static void mergeSort(int arr[], int l, int r) 
	{
		if (l < r) 
		{
			int m = (l + r) / 2;

			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}
	public static int partition(int array[], int low, int high) 
	{
		int pivot = array[high];
		int i = (low - 1);

		for (int j = low; j < high; j++) 
		{
			if (array[j] <= pivot) 
			{
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				for (int m = 0; m < array.length; m++)
				{
					System.out.print(array[m] + " ");
					if (m == array.length - 1)
						System.out.println();
				}
			}

		}

		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		return (i + 1);
	}
	public static void quickSort(int array[], int low, int high) 
	{
		if (low < high) 
		{
			int pi = partition(array, low, high);
			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}
	public static void heapSort(int arr[]) 
	{
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) 
		{
			heapify(arr, n, i);
			for (int m = 0; m < n; m++)
			{
				System.out.print(arr[m] + " ");
				if (m == n - 1)
					System.out.println();
			}
		}

		for (int i = n - 1; i >= 0; i--) 
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
			for (int m = 0; m < n; m++)
			{
				System.out.print(arr[m] + " ");
				if (m == n - 1)
					System.out.println();
			}
		}
	}
    public static void heapify(int arr[], int n, int i) 
    {
    	int largest = i;
    	int l = 2 * i + 1;
    	int r = 2 * i + 2;
  
    	if (l < n && arr[l] > arr[largest])
    		largest = l;
  
    	if (r < n && arr[r] > arr[largest])
    		largest = r;

    	if (largest != i) 
    	{
    		int swap = arr[i];
    		arr[i] = arr[largest];
    		arr[largest] = swap;
  
    		heapify(arr, n, largest);
    	}
    }
}
