import java.util.Scanner;
//================================================================================
public class BandoftheHour {
//--------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    public static final int MAX_ROWS = 10;
    public static final int MAX_POSITIONS = 8;
    public static final int MAX_KG_PER_POS = 100;
    public static final double MIN_MUS_KG = 45.0;
    public static final double MAX_MUS_KG = 200.0;
    public static final double VACANT_POS = 0.0;
//--------------------------------------------------------------------------------
    public static void main(String[] args) {
    
    System.out.println("Welcome to the Band of the Hour");
    System.out.println("-------------------------------");
    
    int index, rows, positions = 0; 

    // ---- Rows ----
    System.out.print("Please enter number of rows             : ");
    rows = keyboard.nextInt();
    while (rows > MAX_ROWS || rows < 0) {
    System.out.print("ERROR: Out of range, try again          : ");
    rows = keyboard.nextInt();
     }
    
    double[][] stadium = new double[rows][];
    
   // ---- Positions ----
    for(index = 0; index < rows; index++) {
        System.out.print("Please enter number of positions in row " 
                         + (char)(65 + index) + " : ");
        positions = keyboard.nextInt();
        while (positions > MAX_POSITIONS || positions <= 0) {
        System.out.print("ERROR: Out of range, try again          : ");
        positions = keyboard.nextInt();
        }
        stadium[index] = new double[positions];
      }
    
    // ---- User Prompt Menu ----
    char command;
    do {
    	System.out.println();
    	System.out.print(" (A)dd, (R)emove, (P)rint,       e(X)it : ");
        command = Character.toUpperCase(keyboard.next().charAt(0));
        options(stadium, command);

     } while (command != 'X');
    
    }
//--------------------------------------------------------------------------------
    private static void options(double[][] stadium, char command) {

            switch (command) {
                case 'A' : add(stadium);
                           break;
                case 'R' : remove(stadium);
                           break;
                case 'P' : print(stadium);
                           break;
                case 'X' : return;
                default: System.out.print("ERROR: Invalid option, try again : ");
                         command = Character.toUpperCase(keyboard.next().charAt(0));
                         options(stadium, command);
            }
   }
//--------------------------------------------------------------------------------
    private static void add(double[][] stadium) {
    	
    	char row;
    	int position;
    	double weight;
    	
    	row = inputRow(stadium);
    	position = inputPosition(stadium, row);
    	
    	
    	// ---- Check Position ----
    	if (stadium[((int)row - 65)][position - 1] > VACANT_POS){
    		System.out.println("ERROR: There is already a musician there");
    		return;
    	}
    	
    	// ---- Input Weight ----
    	System.out.print("Please enter weight (" + MIN_MUS_KG 
    			         + " to " + MAX_MUS_KG + ")    : ");
    	weight = keyboard.nextDouble();
    	while (weight > MAX_MUS_KG || weight < MIN_MUS_KG){
    		System.out.print("ERROR: Out of range, try again          : ");
    		weight = keyboard.nextDouble();
    	}
    	
    	// ---- Add To Array ----
    	boolean exceedsWeightLimit;
    	exceedsWeightLimit = checkLimit(stadium, weight, row);
    	if (exceedsWeightLimit) {
    		System.out.println("ERROR: That would exceed the average " +
    				           "weight limit.");
    	} else {
    		stadium[((int)row - 65)][position - 1] = weight;
            System.out.println("****** Musician added.");
    	}
    	
    	
    }
//--------------------------------------------------------------------------------
	private static void remove(double[][] stadium) {
		
		char row;
		int position;
	
		row = inputRow(stadium);
		position = inputPosition(stadium, row);
		
		// ---- If Vacant / If Not Remove ----
		if (stadium[((int)row - 65)][position - 1] == VACANT_POS){
			System.out.print("ERROR: That position is vacant.");
			System.out.println();
		} else {
			stadium[((int)row - 65)][position - 1] = VACANT_POS;
			System.out.println("****** Musician removed.");
		}
	}
//--------------------------------------------------------------------------------
	private static void print(double[][] stadium) {
		
		int index, position = 0;
		double sum = 0;
		double average;
		
		System.out.println();
		for(index = 0; index < stadium.length; index++) {
			System.out.print((char)(65 + index) + ": ");
	    	for(position = 0; position < stadium[index].length; position++){
	    		System.out.printf("%5.1f ",(float)stadium[index][position]);
	    	}
	    	
	    	// ---- Adds Weight of All Positions ----
	    	for (position = 0; position < stadium[index].length; position++ ){
				sum += stadium[index][position];
			}
	    	
	    	// ---- Average Weight of Row ----
	    	average = sum / stadium[index].length;
	    	System.out.printf("[%7.1f,%7.1f]",(float)sum,(float)average);
	    	System.out.println();
	    	sum = 0.0;
	        average = 0.0;
	    }
	}
//--------------------------------------------------------------------------------    
	private static boolean checkLimit(double[][] stadium,double weight,char row){
	  	
		double sum = 0;
		int position;
		double limit = stadium[((int)row - 65)].length * MAX_KG_PER_POS;
	
		// ---- Adds Weight of All Positions ----
		for (position = 0; position < stadium[((int)row - 65)].length; position++ ){
			sum += stadium[((int)row - 65)][position];
		}
		
		// ---- Checks if Exceeds Limit ----
		double total = sum + weight;
		if (total > limit){
			return true;
		} else {
			return false;
		}
	}
//--------------------------------------------------------------------------------
    private static char inputRow(double[][] stadium){
    	
    	char row;
    	
    	System.out.print("Please enter row letter                 : ");
    	row = Character.toUpperCase(keyboard.next().charAt(0));
    	while (((int)row - 65) >= stadium.length){
    		System.out.print("ERROR: Out of range, try again          : ");
    		row = Character.toUpperCase(keyboard.next().charAt(0));
    	}
    	
    	return row;
    	
    }
//--------------------------------------------------------------------------------
    private static int inputPosition(double[][] stadium, char row){
    	
    	int position;
    	
    	System.out.print("Please enter position number (1 to " 
                         + stadium[((int)row - 65)].length + ")   : ");
        position = keyboard.nextInt();
        while (position > stadium[((int)row - 65)].length || position < 1){
	        System.out.print("ERROR: Out of range, try again          : ");
	        position = keyboard.nextInt();
        }
        return position;
    }
//--------------------------------------------------------------------------------    
}
//================================================================================
