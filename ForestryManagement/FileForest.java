package ForestryManagement;

import java.io.*;
//=============================================================================
@SuppressWarnings("serial")
public class FileForest implements Serializable {
//-----------------------------------------------------------------------------
    private static final int MAX_TREES = 10;
    private static final int MIN_GROWTH_RATE = 50;
    @SuppressWarnings("unused")
	private static final int MAX_GROWTH_RATE = 100;
    private static final double MAX_HEIGHT = 5.0;
    private static final double MIN_HEIGHT = 1.0;


    private String name;
    private FileTree[] treesInForest;
    private double height;
    private int growthRate;
//-----------------------------------------------------------------------------
    public FileForest() {

    	// Constructor
        int index;
        
    	name = null;
        treesInForest = new FileTree[MAX_TREES];
        for (index = 0; index < treesInForest.length; index++) {
        	treesInForest[index] = null;
        }
        
    }
//-----------------------------------------------------------------------------
    public FileForest(String name) {

    	// Name forest object
        this.name = name;
        int index;
        
        treesInForest = new FileTree[MAX_TREES];
        for (index = 0; index < treesInForest.length; index++) {
        	treesInForest[index] = plantTree(index);
        }
        
    }
 //-----------------------------------------------------------------------------
    public FileTree plantTree(int index) {

     // Plant trees from 1' to 5' && with 50% - 100% growth rates
       do {
                height = Math.random() * 10;
       }  while (height > MAX_HEIGHT || height < MIN_HEIGHT);
       do {
                growthRate = (int) (Math.random() * 100);
        } while (growthRate <= MIN_GROWTH_RATE);
        treesInForest[index] = new FileTree(height, growthRate);
        return(treesInForest[index]);
    }
//-----------------------------------------------------------------------------
    public void growthYear() {

    	// Grow trees
    	
        int index;
   
        for (index = 0; index < treesInForest.length; index++) {
    	     treesInForest[index].height = treesInForest[index].height * (1+((double)growthRate/100));       
        }
        
    }
//-----------------------------------------------------------------------------
    public void display() {

    	// Diplays all trees in forest
        int index;
        if (name == null) {
            System.out.println("No Forest");
        } else {
        System.out.println(name);
        for (index = 0; index < treesInForest.length; index++) {
            System.out.print(" " + (index+1) + " :    ");
            System.out.println(treesInForest[index]);
            }
        }
    }
//-----------------------------------------------------------------------------
    public void reap(int reapHeight) {

    	// cuts down trees at certain height and replaces them
        int index;
        
        for(index = 0; index < treesInForest.length; index++) {
        	if (treesInForest[index].height >= reapHeight) {
        		System.out.print(" Cut " + (index+1) + "  : ");
        		System.out.println(treesInForest[index]);
        		System.out.print(" New " + (index+1) + "  : ");
        		treesInForest[index] = plantTree(index);
        		System.out.println(treesInForest[index]);
        	}
        }

   }
//-----------------------------------------------------------------------------
    public String getName () {

        return(name);
    }
//-----------------------------------------------------------------------------
}
//=============================================================================