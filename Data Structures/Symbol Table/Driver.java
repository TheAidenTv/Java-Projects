import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

/**
 * Write a description of class Driver here.
 *
 * @author Aiden Timmons
 * @version March 24, 2023
 */
public class Driver
{
    public static void main(String[] args) throws Exception
    {   
        // Instance Variables
        // word represents each word of the file input
        String word;
        BST symbolTable = null;
        // wordSearch is the user input string for searching
        String wordSearch = "";
        // occurence is how many occurences of searched word
        int occurence = 0;
        
        // Trying to read file with possible file not found exception thrown
        try
        {
            File myFile = new File("NewStory.txt");
            Scanner scan = new Scanner(myFile);
            
            // If the file has a word, read it and use it to create BST
            if(scan.hasNextLine())
            {
                word = scan.nextLine();
                
                symbolTable = new BST(word);
            }
            
            // For the remainder of the file, while theres another word
            // to read, add it to our symbol table BST only if it exceeds
            // 3 characters of length
            while(scan.hasNextLine())
            {
                word = scan.nextLine();
                
                // If the word is greater than 3 characters, 
                // convert it to lower case and add to the BST
                if(word.length() > 3)
                {
                    word = word.toLowerCase();
                    symbolTable.put(word);
                }
            }
        }
        // Catching exception and printing to user
        catch(FileNotFoundException e)
        {
            System.out.println("The file was not found.");
            e.printStackTrace();
        }
        
        // Printing out the symbol table in alphabetical order
        symbolTable.printBST();
        
        System.out.println("\n** End of word count **\n");
        
        Scanner input = new Scanner(System.in);
        
        // While the user has another word to search for, find how
        // many occurences there are of their word until they 
        // enter STOP as their input.
        do{
            System.out.print("What word would you like to search? ");
            System.out.println("Type \"STOP\" to end word search"); 
            
            wordSearch = input.nextLine();
            
            if(wordSearch.equals("STOP"))
               break;
            
            // Num of occurences equals the return of their search
            // Also converting their query to lowercase to match BST
            occurence = symbolTable.contains(wordSearch.toLowerCase());
            
            System.out.println(wordSearch + " appears " + occurence
                               + " times.");
        }while(!wordSearch.equals("STOP"));
        
        System.out.println("\n** Max Values: **\n");
        
        symbolTable.printMax();
    }
}
