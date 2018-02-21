package ForestryManagement;

import java.io.*;
//=============================================================================
@SuppressWarnings("serial")
public class FileTree implements Serializable {
//-----------------------------------------------------------------------------
    public double height;
    public int growthRate;
//-----------------------------------------------------------------------------
    public FileTree() {

    	// Constructor
        this.height = 0.0;
        this.growthRate = 0;
    }
//-----------------------------------------------------------------------------
    public FileTree(double height, int growthRate) {

        this.height = height;
        this.growthRate = growthRate;
    }
//-----------------------------------------------------------------------------
    public String toString() {

    	// Print formatting
        return(String.format("%.2f (%2.0f%%  pa)", height, (float)growthRate));

    }
//-----------------------------------------------------------------------------
    public void setHeight (double height) {

        this.height = height;

    }
//-----------------------------------------------------------------------------
    public double getHeight() {

        return(height);
    }
//-----------------------------------------------------------------------------
} 
//=============================================================================
