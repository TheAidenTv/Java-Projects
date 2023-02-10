/**
 * A class that solves the Union Find problem using the Weighted Quick Union 
 * algorithm while path compressing the tree during the root() method call.
 *
 * @author Aiden Timmons
 * @version Febuary 6, 2023
 */
public class WeightedQuickUnion
{
    // instance variables
    // id array keeps track of the parent of each element
    private int[] id;
    // size array keeps track of how many nodes are connected
    // to the node of the index
    private int[] size;
    
    /**
     * Constructor for objects of class QuickFind
     *
     * @param N the size of the array to initialize
     */
    public WeightedQuickUnion(int N)
    {
        id = new int[N];
        size = new int[N];
        
        for(int i = 0; i < id.length; i++)
        {
            id[i] = i;
            size[i] = 1;
        }
    }
    
    /**
     * A method that performs union on p and q
     * by setting the root the smaller tree to
     * be a child of the larger tree
     *
     * @param p the first element to union
     * @param q the second element to union
     */
    public void union(int p, int q)
    {
        // Get the root of the two elements
        int rootP = root(p);
        int rootQ = root(q);
        
        // If the roots are the same, they are already connected
        if(rootP == rootQ)
            return;
        
        // If the size of the tree of p is greater than the size of the tree of q
        if(size[rootP] > size[rootQ])
        {
            // Set the root of q to the root of p
            id[rootQ] = rootP;
            // Add the size of q to the size of p
            size[rootP] += size[rootQ];
        }
        else
        {
            // Set the root of p to the root of q
            id[rootP] = rootQ;
            // Add the size of p to the size of q
            size[rootQ] += size[rootP];
        }
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
     * A method that finds the root of a given element in id[]
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
    
    /**
     * A method that prints out the contents of the size array
     * in the style of an array
     */
    public void printSize()
    {
        System.out.print("[");
        for(int i = 0; i < size.length; i++)
        {
            System.out.printf("%2d", size[i]);

            if (i != size.length - 1) 
                System.out.print(", ");
        }
        System.out.println("]");
    }
}