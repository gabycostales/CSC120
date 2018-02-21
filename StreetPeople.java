import java.util.Scanner;

public class StreetPeople {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        int numberOfHouses, index, houseNumber;

        System.out.print("How many houses in the street?         : ");
        numberOfHouses = keyboard.nextInt();
        int[] houseNumbers = new int[numberOfHouses];
        System.out.println();

        // ---- houseNumbers array ------
        for (index = 0; index < numberOfHouses; index++) {
            System.out.print("What is the next house number?         : ");
            houseNumber = keyboard.nextInt();
            houseNumbers[index] = houseNumber;
        }

        // ---- houseAges array -----
        int[][] houseAges = new int[numberOfHouses][];
        int age, people, person;

        for (index = 0; index < houseAges.length; index++) {
            System.out.print("\n" + "How many people live in house number " + houseNumbers[index] + " : ");
            people = keyboard.nextInt();
            houseAges[index] = new int[people];
            for (person = 0; person < people; person++) {
                System.out.print("What is the age of person " + (person+1) + "            : ");
                age = keyboard.nextInt();
                houseAges[index][person] = age;
            }
        }
        System.out.println();

        // ---- Analysis ----
        int sum, streetSum;
        sum = 0;
        streetSum = 0;

        for (index = 0; index < houseAges.length; index++) {
            for (person = 0; person < houseAges[index].length; person++) {
                sum += houseAges[index][person];
            }
            System.out.println("House " + houseNumbers[index] + "has a total age of " + sum);
            streetSum += sum;
            sum = 0;
        }

        System.out.println("\n" + "The street has a total age of " + streetSum);

    }

}