import java.util.Scanner;

public class PizzaCost {

    private static Scanner keyboard = new Scanner(System.in);
    //----Pi is 3.14159265
    private static final double PI = 3.14159265;

    public static void main(String[] args) {

//----Variables to hold cost, unit cost, diameter
        double cost;
        double diameter;
        double unitCost;

//----Get data
        System.out.print("What size pizza   : ");
        diameter = keyboard.nextDouble();
        System.out.print("What does it cost : ");
        cost = keyboard.nextDouble();

//----Perform computation
        unitCost = computeUnitCost(diameter,cost);

//----Display the diameter, the total cost, and the unit cost
        System.out.println("Diameter is   " + diameter);
        System.out.println("Total cost is " + cost);
        System.out.println("Unit cost is  " + unitCost);

    }

     private static double computeUnitCost(double diameter,double cost) {

        double area;
        double radius;

//----Area is 3.14 times radius squared
        radius = diameter / 2;
        area = PI * radius * radius;
//----Unit cost is total cost divided by area
        return(cost/area);

    }

}