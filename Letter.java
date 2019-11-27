import javafx.beans.property.ReadOnlyLongProperty;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Letter {
    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter dimensions (HxW) for the envelopes, first two chars are for First envelope, other two " +
                    "chars are for the Second envelope: ");
            try {
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                double c = sc.nextDouble();
                double d = sc.nextDouble();
                if (a > c && b > d) {
                    System.out.println("Second Envelope could be placed inside the First Envelope");
                } else if (a < c && b < d) {
                    System.out.println("First Envelope could be placed inside the Second Envelope");
                } else {
                    System.out.println("Envelopes cannot be placed in each other");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input is not a number");
            }
        } while (true);
    }
}
