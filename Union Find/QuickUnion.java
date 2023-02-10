/**
 * A class that solves the Union Find problem using the Quick Union algorithm
 *
 * @author Aiden Timmons
 * @version Febuary 6, 2023
 */
public class QuickUnion
{
    // instance variables
    // id array keeps track of the parent of each element
    private int[] id;
    
    /**
     * Constructor for objects of class QuickFind
     *
     * @param N the size of the array to initialize
     */
    public QuickUnion(int N)
    {
        id = new int[N];
        
        // Each element starts off by being their own parent
        for(int i = 0; i < id.length; i++)
        {
            id[i] = i;
        }
    }
    
    /**
     * A method that performs union on p and q
     * by setting the root of p to be a child
     * of the root of q
     *
     * @param p the first element to union
     * @param q the second element to union
     */
    public void union(int p, int q)
    {
        // The root of p becomes a child of the root of q by "pointing" to root of q
        id[root(p)] = id[root(q)];
    }
    
    
    
    
    
    
    
    
    
    /**
     * A method that checks if two elements are connected
     * by seeing if they share the same root
     *
     * @param p the first element to check
     * @param q the second element to check
     * @return true if they have the same root, false otherwise
     */
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }
    
    /**
     * A method that finds the root of a
     * given element from the id array
     *
     * @param element - the element to find the root of
     * @return the root value of the element given
     */
    public int root(int element)
    {
        // If parent is itself, we have the root and we return
        if(id[element] == element)
        {
            return element;
        }
        
        // Recurssive call to get the next parent until we find the root
        return root(id[element]);
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