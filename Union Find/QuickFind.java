/**
 * A class that solves the Union Find problem using the Quick Find algorithm
 *
 * @author Aiden Timmons
 * @version Febuary 6, 2023
 */
public class QuickFind
{
    // instance variables
    // id array keeps track of what set each element belongs to
    private int[] id;

    /**
     * Constructor for objects of class QuickFind
     *
     * @param N the size of the array to initialize
     */
    public QuickFind(int N)
    {
        // initialise instance variables
        id = new int[N];
        
        // Each element starts off by being in its own unique set
        for(int i = 0; i < id.length; i++)
        {
            id[i] = i;
        }
    }
    
    /**
     * A method that performs union on p and q
     * by making the id[p] = id[q]
     *
     * @param p the first element to union
     * @param q the second element to union
     */
    public void union(int p, int q)
    {
        int tempP = id[p];
        
        // Look through the entire array to change ALL p's to q's
        for(int i = 0; i < id.length; i++)
        {
            if(id[i] == tempP)
            {
                id[i] = id[q];
            }
        }
    }
    
    /**
     * A method that checks if two elements are connected
     * by seeing if they are in the same set or id[] value
     *
     * @param p the first element to check
     * @param q the second element to check
     * @return true if they have the same id, false otherwise
     */
    public boolean connected(int p, int q)
    {
        return id[p] == id[q];
    }
    
    /**
     * A method that prints out the contents of the id array
     * in the style of an array
     */
    public void printID()
    {
        System.out.print("[");
        for(int i = 0; i < id.length; i++)
        {
            System.out.printf("%2d", id[i]);

            if (i != id.length - 1) 
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
