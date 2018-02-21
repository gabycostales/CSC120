import java.util.Scanner;

public class MetricConversion {

		private static Scanner keyboard = new Scanner(System.in);
		// Square yards is 1.196 times the square metres
		private static final double SQUARE_YARDS_TO_METERS_RATIO = 1.196;

		public static void main(String[] args) {

				double squareMeters,squareYards;

				// Gather data
				System.out.print("How many square meters : ");
				squareMeters = keyboard.nextDouble();

				// Perform calculation
				squareYards = squareMeters * SQUARE_YARDS_TO_METERS_RATIO;

				// Display results
				System.out.println(squareMeters + " square meters is " + squareYards + " square yards");

		}

}

