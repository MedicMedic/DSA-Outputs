package queue;
import java.util.Scanner;

public class Queue 
{
	static int SIZE;
	static int items[];
	int front, rear;
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int i = 0, enqinp = -1;
		
		System.out.print("Enter the size of the Queue: ");
		SIZE = input.nextInt();
		items = new int[SIZE];
		
		Queue q = new Queue();
		
		System.out.println("Menu\n");
		
		do 
		{
			System.out.println("1. Enqueue\n2. Dequeue\n3. Display Queue\n4. Exit");
			System.out.print("Enter Choice [1...4]: ");
			int menunum = input.nextInt();
			
			switch (menunum)
			{
				case 1: System.out.println("\nENQUEUE");
						System.out.print("Enter a number: ");
						enqinp = input.nextInt();
						q.enQueue(enqinp);
						q.display();
						break;
				case 2: System.out.println("\nDEQUEUE");
						q.deQueue();
						q.display();
						break;
				case 3: System.out.println("\nDISPLAY");
						q.display();
						break;
				case 4: System.out.println("\nEXIT");
						System.out.println("Edic, Marianne");
						i = 1;
						break;
			}
		} while (i == 0);
	}
	
	Queue() 
	{
		front = -1;
		rear = -1;
	}

	boolean isFull() 
	{
		if (front == 0 && rear == SIZE - 1) 
		{
			return true;
		}
		if (front == rear +1)
		{
			return true;
		}
		return false;
	}

	boolean isEmpty() 
	{
		if (front == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	void enQueue(int element) 
	{
		if (isFull()) 
		{
			System.out.println("Queue Overflow");
		}
		else 
		{
			if (front == -1)
			{
				front = 0;
			}
			rear = (rear + 1) % SIZE;
			items[rear] = element;
		}
	}

	int deQueue() 
	{
		int element;
		
		if (isEmpty()) 
		{
			System.out.println("Queue is empty");
			return (-1);
		}
		else 
		{
			element = items[front];
			if (front == rear) 
			{
				front = -1;
				rear = -1;
			}
			else 
			{
				front = (front + 1) % SIZE;
			}
			System.out.println( element + " Deleted");
			return (element);
		}
	}

	void display()
	{
		int i;
		if (isEmpty()) 
		{
			System.out.println("Empty Queue");
		}
		else 
		{
			System.out.print("Queue: ");
			for (i = front; i != rear; i = (i+1) % SIZE)
			{
				System.out.print(items[i] + " ");
			}
			System.out.println(items[i]);
			System.out.println("\nFront: " + front);
			System.out.println("Rear: " + rear);
			System.out.println();
		}
	}
}