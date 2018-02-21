package ForestryManagement;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

//=============================================================================
public class FileLumberjack {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

     FileForest forest;   
     String name;
     String nextForestName;
     int reapHeight = 0;
     char option;

     // creates object for forest
     forest = new FileForest();

    // User Interface, Display Options
        do {
        	    System.out.println();
                System.out.print("(D)isplay, (N)ew, (Y)ear, (R)eap, (S)ave, (L)oad, e(X)it : ");
                option = Character.toUpperCase(keyboard.next().charAt(0)); 
    
                switch (option) {
                    case 'D':
                        forest.display();
                        break;

                    case 'N':
                        System.out.print("What is the forest name?  :  ");
                        name = keyboard.next();
                        forest = new FileForest(name);                  
                        break;

                    case 'Y':
                        forest.growthYear();
                        break;

                    case 'R':
                        System.out.print("what height to reap at : ");
                        while (reapHeight == 0) {
                               try {
                                   reapHeight = keyboard.nextInt();
                                   forest.reap(reapHeight);            
                               } catch (InputMismatchException e) {
                                 System.out.print("ERROR: Invalid height :");   
                                 reapHeight = 1;
                               }     
                        } 
                        reapHeight = 0; 
                        break;

                    case 'S':
                        name = forest.getName();
                        try {
                            saveForest(name,forest);
                        } catch (IOException e) {
                            System.out.println("ERROR saving " + e.getMessage());
                            return;
                        }
                        break;

                    case 'L':
                        System.out.print("What is the forest name  :");
                        nextForestName = keyboard.next();
                        
                        try {
                            loadForest(nextForestName);
                        } catch (Exception e){
                            System.out.println("ERROR Loading " + e.getMessage());
                            return;
                        }
                        
                        name = nextForestName;
                        
                        break; 

                    case 'X':
                        System.out.println("Goodbye");
                        break;

                    default:
                        System.out.println("ERROR, Invalid option");
                        break;
                }
        } while (option != 'X'); 

       return;
    }
//-----------------------------------------------------------------------------
    private static void saveForest(String name, FileForest Forest)
throws IOException {

    	// Saves forest to local directory 
        ObjectOutputStream toStream;

        toStream = new ObjectOutputStream(new FileOutputStream(name));
        toStream.writeObject(Forest);
        toStream.close();

    }
//-----------------------------------------------------------------------------
    private static FileForest loadForest(String nextForestName)
throws IOException, ClassNotFoundException {
 
    	//loads forest from local directory
        ObjectInputStream fromStream;
        FileForest nextForest;
        
        fromStream = new ObjectInputStream(new FileInputStream(nextForestName));
        nextForest = (FileForest)fromStream.readObject();
        fromStream.close();
        return(nextForest);
       

    }
//-----------------------------------------------------------------------------
}
//=============================================================================

