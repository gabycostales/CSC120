import java.util.Scanner;

public class IAm {

    public static void main(String[] args) {

        String input;
        String myQuality;
        String mySentence = "The qualities are ";

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter sentences, . to end.");

        do {
            input = keyboard.nextLine();
            if (input.startsWith("I am")) {
                myQuality = input.substring(5);
                mySentence += myQuality + ", ";
            }
        } while (!input.contains("."));

        System.out.println("\n" + mySentence);
        keyboard.close();
    }
}