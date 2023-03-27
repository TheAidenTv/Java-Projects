/**
 * This is a binary search tree that has been modified to function as
 * a symbol table. This symbol table is used to hold words of a text
 * file (key) along with how many occurences of the word (symbol). 
 *
 * We will sort on the word alphabetically when storing it in the tree.
 *
 * @author Aiden Timmons
 * @version March 24, 2023
 */
public class BST
{
    // A BST only has a root where the root has its own children
    private Node root;

    /**
     * Constructor for objects of class BST
     */
    public BST(String firstWord)
    {
        // The root is given with the creation of a BST
        root = new Node(firstWord);
    }
    
    /**
     * This is a method that inserts a given key into the BST symbol
     * table and will call insert node if it is a valid key to actually
     * insert it into the BST. Otherwise it will throw an exception if
     * the key given was invalid
     *
     * @param key The key (word) to insert into our symbol table
     */
    public void put(String key) throws Exception
    {
        // If they try to give an invalid key, throw an exception 
        if(key == null)
        {
            throw new Exception("Invalid Key Type");
        }
        
        // Otherwise, insert the node given the key (word)
        root = insertNode(root, key);
    }
    



    /**
     * This method creates a new node given the key (word) and will
     * insert it into the BST in the correct alphabetical location
     * by recursively traversing the tree.
     * 
     * If the key (word) already exists in our tree it will simply
     * increment the symbol (occurence) of the word.
     *
     * @param node The root of the subtree to insert into
     * @param key The key that must be created into a node
     */
    private Node insertNode(Node node, String key)
    {
        // Base case - we reached a spot to insert
        if(node == null)
        {
            return new Node(key);
        }
        
        // If the key (word) is less than the parents key (word)
        // Go to the parents left child and try again.
        if(key.compareTo(node.getKey()) < 0)
        {
            node.setLeft(insertNode(node.getLeft(), key));
        }
        // If the key (word) is greater than the parent key (word)
        // Go to the parents left child and try again.
        else if(key.compareTo(node.getKey()) > 0)
        {
            node.setRight(insertNode(node.getRight(), key));
        }
        // Otherwise the words must be the same, in that case
        // We just increment its symbol value (frequency of word)
        else
        {
            node.incrementValue();
        }
        
        return node;
    }
    






    /**
     * This method searchs for a given key (word) in the symbol table
	 * and returns the number of occurences of the word or 0 if the
	 * word is not found.
     *
     * @param key The key (word) to search the BST for
     * @return The number of occurences the key (word) appears. 
     * Returns 0 if the key (word) isn't in the tree
     */
    public int contains(String key)
    {
        // Current is a temp node to traverse the BST
        Node current = root;
        
        // While there is a current node keep checking
        // We use this while-loop approach since we do
        // not know the length of our BST
        while(current != null)
        {
            // This is similar to inserting a new node,
            // first we must find the location that it would be
            
            // If given key < current key, go to left
            if(key.compareTo(current.getKey()) < 0)
            {
                current = current.getLeft();
            }
            // If given key > current key, go to right
            else if (key.compareTo(current.getKey()) > 0)
            {
                current = current.getRight();
            }
            // Else it must be there so we can return it
            else
            {
                return current.getSymbolValue();
            }
        }
        
        // If nothing got returned and we made it this far
        // than the given key must not be there. Return 0 occurences
        return 0;
    }
    
    /**
     * A user friendly helper method for the user to call if they wish
     * to print the tree without them needing to pass anything in
     */
    public void printBST()
    {
        // Calls the better print method given the starting location
        printKeyOrder(root);
    }
    
    /**
     * This method prints the BST symbol table in alphabetical order
     * given a starting location by recursively calling the left sub 
     * tree, then printing the node then recursively calling the right
     *
     * @param node The starting location (Root to print all)
     */
    private void printKeyOrder(Node node)
    {
        // Base case - we reached the end of a subtree
        if(node == null)
        {
            return;
        }
        
        // L - Print Left
        printKeyOrder(node.getLeft());

        // N - Ptint Node
        System.out.println("(" + node.getKey() + "," + 
                            node.getSymbolValue() + ")");
        
        // R - Print Right
        printKeyOrder(node.getRight());
    }
    
    /**
     * A user friendly helper method for the user to call if they wish
     * to print the max key (word) occurences without them needing to
     * pass any parameters
     */
    public void printMax() 
    {
        int max = findMax(root, 0);
        
        // Calls the better print max method
        printMaxNodes(root, max);
    }
    
    /**
     * This method finds the key (word) with the highest symbol value
     * (word occurences) in the BST. It does this by brute force of 
     * starting with max = 0 and scans the entire tree, replacing the
     * max if there exists a symbol value higher than it.
     *
     * @param node The starting location (Root to scan entire tree)
     * @param max The inital max value (Typically 0)
     * @return The maximum symbol value in the tree
     */
    private int findMax(Node node, int max) 
    {
        // Base case - we reached the end of a subtree
        if (node == null) 
        {
            return max;
        }
        
        // If the current symbol value is greater than
        // our current max, replace our max with it
        if (node.getSymbolValue() > max) 
        {
            max = node.getSymbolValue();
        }
        
        // Find the max of the left/right subtrees
        max = findMax(node.getLeft(), max);
        max = findMax(node.getRight(), max);
        
        return max;
    }
    
    /**
     * This method prints the maximum symbol values (word occurences)
     * in the tree given a starting location then, recursively calling
     * the left sub tree, then only printing the node if its equal to 
     * the given value, then recursively calling the right sub tree
     *
     * @param node The starting location (Root to print all)
     * @param max The value condition to print on. The node must equal
     * this value in order to be printed
     */
    private void printMaxNodes(Node node, int max) 
    {
        // Base case - we reached the end of a subtree
        if (node == null) 
        {
            return;
        }
        
        // L - Print Left
        printMaxNodes(node.getLeft(), max);
        
        // N - Print Node IFF its equal to the max
        if (node.getSymbolValue() == max) 
        {
            System.out.println("(" + node.getKey() + "," + 
                                node.getSymbolValue() + ")");
        }
        
        // R - Print Right
        printMaxNodes(node.getRight(), max);
    }
}