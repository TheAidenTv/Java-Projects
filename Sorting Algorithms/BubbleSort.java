import java.util.Random;

/**
 * A Java class that implements the Bubble Sort algorithm to sort a given list of ints.
 * 
 * Bubble sort is a simple sorting algorithm that repeatedly compares adjacent elements
 * of an array and swaps them if they are in the wrong order. The algorithm passes through
 * the array multiple times until no more swaps are necessary, indicating that the array
 * is now sorted.
 *
 * @author Aiden Timmons
 * @version Febuary 17, 2023
 */
public class BubbleSort
{
    
    public static void main(String[] args)
    {
        // Instance Variables
        int[] myList = new int[10];
        Random rand = new Random();
        
        // Randomizing the elements in the list
        for(int i = 0; i < myList.length; i++)
        {
            myList[i] = rand.nextInt(25);
        }
        
        // Printing the initial list
        System.out.println("Initial List");
        printList(myList);
        
        // Sorting the list
        sort(myList);
        
        // Printing the sorted list
        System.out.println("\nSorted List");
        printList(myList);
    }
    
    /**
     * A method that performs bubble sort on a given list of integers
     * and sorts them in ascending order
     * 
     * @param list, the array of integers to be sorted
     */
    public static void sort(int[] list)
    {
        int n = list.length;
        
        // Controls number of passes through the list, no need to loop on the last
        // element as it is guaranteed to be sorted after the first pass
        for(int i = 0; i < n - 1; i ++)
        {
            // Compare each element to its next element by starting at 0 and comparing
            // all the elements up to n which is where the list is already sorted.
            for(int j = 0; j < n - i - 1; j++)
            {
                // If the current element is bigger than the next element, swap them
                if(list[j] > list[j+1])
                {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
    }
    
    /**
     * A method that prints out the given list
     * in the style of an array
     */
    public static void printList(int[] list)
    {
        System.out.print("[");
        for(int i = 0; i < list.length; i++)
        {
            System.out.printf("%2d", list[i]);

            if (i != list.length - 1) 
                System.out.print(", ");
        }
        System.out.println("]");
    }
}