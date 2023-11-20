package sorting;
import java.util.Scanner;

public class Sorting 
{
	public static void main(String[] args)
	{
		int A[] = {31, 5, -1, 9, 0, 6};
		Scanner input = new Scanner(System.in);
		
		System.out.println("1. Bubble Sort\n2. Insertion\n3. Selection\n4. Merge\n5. Quick Sort\n6. Heap Sort");
		System.out.print("Select sort: ");
		int operation = input.nextInt();
		
		switch (operation)
		{
			case 1: bubbleSort(A);
					break;
			case 2: insertionSort(A);
					break;
			case 3: selectionSort(A);
					break;
			case 4: mergeSort(A, 0, A.length - 1);
					break;
			case 5: quickSort(A, 0, A.length -1 );
					break;
			case 6: heapSort(A);
					break;
		}
		System.out.print("Sorted Array in Ascending Order: ");
		for (int i = 0; i < A.length; i++)
		{
			System.out.print(A[i] + " ");
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
				}
			}
			for (int m = 0; m < array.length; m++)
			{
				System.out.print(array[m] + " ");
			}
			System.out.println();
			if (!swapped)
				break;
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
			}
			for (int m = 0; m < array.length; m++)
			{
				System.out.print(array[m] + " ");
			}
			System.out.println();
			array[j + 1] = key;
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
			for (int m = 0; m < array.length; m++)
			{
				System.out.print(array[m] + " ");
			}
			System.out.println();
			int temp = array[step];
			array[step] = array[min_idx];
			array[min_idx] = temp;
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
		}	
		for (int j = 0; j < n2; j++)
		{
			M[j] = arr[q + 1 + j];
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
		for (int m = 0; m < arr.length; m++)
		{
			System.out.print(arr[m] + " ");
		}
		System.out.println();
  }
	public static void mergeSort(int arr[], int l, int r) 
	{
		if (l < r) 
		{
			int m = (l + r) / 2;

			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
			for (int q = 0; q < arr.length; q++)
			{
				System.out.print(arr[q] + " ");
			}
			System.out.println();
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
			}

		}

		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		
		for (int q = 0; q < array.length; q++)
		{
			System.out.print(array[q] + " ");
		}
		System.out.println();

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
		}

		for (int i = n - 1; i >= 0; i--) 
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
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
    	for (int q = 0; q < arr.length; q++)
		{
			System.out.print(arr[q] + " ");
		}
		System.out.println();
    }
}

