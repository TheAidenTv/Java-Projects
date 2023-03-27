
/**
 * This class represents the node objects that make up a binary search
 * tree we use. Of course I didn't Really need to have a node class as
 * a binary search tree is made up of other BST's but this works too
 * 
 * @author Aiden Timmons
 * @version March 24, 2023
 */
public class Node
{
    // Instance Data
    // Key will hold the word
    private String key;
    // SymbolValue will hold the occurence of the word
    private int symbolValue;
    // Left and Right children of this node object
    private Node left, right;

    /**
     * Constructor for objects of class Node
     */
    public Node(String newKey)
    {
        // key because given key
        key = newKey;
        // Symbol value starts at 1 occurence
        symbolValue = 1;
    }
    
    // Getters and Setters of instance data
    
    public Node getLeft()
    {
        return left;
    }
    
    public void setLeft(Node newLeft)
    {
        left = newLeft;
    }
    
    public Node getRight()
    {
        return right;
    }
    
    public void setRight(Node newRight)
    {
        right = newRight;
    }
    
    public int getSymbolValue()
    {
        return symbolValue;
    }
    
    public String getKey()
    {
        return key;
    }
    
    // IncrementValue() is used to increase the
    // Occurence of the word if we try inserting a 
    // word that already exists
    public void incrementValue()
    {
        symbolValue++;
    }
}
