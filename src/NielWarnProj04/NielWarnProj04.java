/*
 *   Warner Nielsen
 *   2/11/19
 *   Project 04
 *   CS 2420
 *   Garth Sorenson
 * */


/*
*   This is the driver class to run the program. The user
*   will be solicited for information and the program will
*   run based off the user input.
* */
package NielWarnProj04;

import java.util.Scanner;

public class NielWarnProj04 {
    public static void main(String[] args) {
        // Welcome message and explanation of how to use the program
        System.out.println("Welcome to the Polynomial generator and manipulator!");
        System.out.println("\nThe program will prompt you to enter in values for two" +
                            "\ndifferent polynomials. If a coefficient and power" +
                            "\nexist for a polynomial you can edit that coefficient" +
                            "\nand power with new values. If a coefficient and power" +
                            "\ndon't exist in a polynomial, it will be created.");

        displayMenu(); // implement displayMenu() method written outside of main
    }

    // this method displays the menu and also sets the variables to be used by the user
    public static void displayMenu() {
        // Creation of new Polynomials to be used in the program
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial p3 = new Polynomial();
        int coeff, power, usrMenuChoice, x;
        boolean stopLoop = false;
        Scanner input = new Scanner(System.in);

        do {
            // display menu choices to run each Polynomial method
            System.out.println("\nMenu:");
            System.out.println("\t1 - Set values for the FIRST polynomial");
            System.out.println("\t2 - Set values for the SECOND polynomial");
            System.out.println("\t3 - Display FIRST polynomial");
            System.out.println("\t4 - Display SECOND polynomial");
            System.out.println("\t5 - Add FIRST and SECOND polynomials together");
            System.out.println("\t6 - Evaluate FIRST polynomial with value 'x'");
            System.out.println("\t7 - Evaluate SECOND polynomial with value 'x'");
            System.out.println("\t8 - Quit");

            Scanner menuChoiceScanner = new Scanner(System.in);

            System.out.print("\nEnter a choice: ");
            usrMenuChoice =  menuChoiceScanner.nextInt();

            // switch case to be used for the menu
            switch (usrMenuChoice) {
                case 1:
                    // get the coefficient, positive or negative from user
                    System.out.print("Please enter a coefficient for the first polynomial (pos/neg integer value): ");
                    coeff = input.nextInt();
                    System.out.println("You entered " + coeff + " for the coefficient of the first polynomial.");

                    // validate for positive numbers and integer values
                    do {
                        System.out.print("\nPlease enter a power for the first polynomial (pos integer value): ");
                        while(!input.hasNextInt()) {
                            System.out.println("That's not an integer value.");
                            System.out.print("Please enter a power for the first polynomial (pos integer value): ");
                            input.next();
                        }
                        power = input.nextInt();
                    }while (power < 0);

                    // read back to user what they entered
                    System.out.println("You entered " + power + " for the power of the first polynomial.");
                    // use the user values to set the coeff using the method
                    p1.setCoefficient(coeff, power);
                    break;
                case 2:
                    // get the coefficient, positive or negative from user
                    System.out.print("\nPlease enter a coefficient for the second polynomial (pos/neg integer value): ");
                    coeff = input.nextInt();
                    System.out.println("You entered " + coeff + " for the coefficient of the second polynomial.");

                    // validate for positive numbers and integer values
                    do {
                        System.out.print("\nPlease enter a power for the second polynomial (pos integer value): ");
                        while(!input.hasNextInt()) {
                            System.out.println("That's not an integer value.");
                            System.out.print("Please enter a power for the second polynomial (pos integer value): ");
                            input.next();
                        }
                        power = input.nextInt();
                    }while (power < 0);

                    // read back to user what they entered
                    System.out.println("You entered " + power + " for the power of the second polynomial.");
                    // use the user values to set the coeff using the method
                    p2.setCoefficient(coeff, power);
                    break;
                case 3:
                    // print out the first polynomial
                    System.out.println("\nThe first polynomial reads: " + p1.toString());
                    break;
                case 4:
                    // print out the second polynomial
                    System.out.println("\nThe second polynomial reads: " + p2.toString());
                    break;
                case 5:
                    // assign the addition of the two polynomials to a third polynomial
                    p3 = p1.add(p2);
                    // print out the polynomials and the added one
                    System.out.println("\nThe first polynomial: " + p1.toString() +
                            "\nAdded to the second polynomial: " + p2.toString() +
                            "\nReads: " + p3.toString());
                    break;
                case 6:
                    // use a value from the user to evaluate the first polynomial
                    System.out.print("Please enter a value for 'x' to evaluate the first polynomial: ");
                    x = input.nextInt();
                    // print the first polynomial pre-evaluation
                    System.out.println("The first polynomial reads: " + p1.toString());
                    // print the first polynomial post-evaluation
                    System.out.println("The first polynomial evaluates to " + p1.evaluate(x) + ", with " + x + " as the value for x.");
                    break;
                case 7:
                    // use a value from the user to evaluate the second polynomial
                    System.out.print("Please enter a value for 'x' to evaluate the second polynomial: ");
                    x = input.nextInt();
                    // print the second polynomial pre-evaluation
                    System.out.println("The second polynomial reads: " + p2.toString());
                    // print the second polynomial post-evaluation
                    System.out.println("The second polynomial evaluates to " + p2.evaluate(x) + ", with " + x + " as the value for x.");
                    break;
                case 8:
                    // quit the program
                    stopLoop = true;
                    break;
                default:
                    // validate against incorrect menu choices
                    System.out.println("Invalid choice, please try again...");
            }
        } while(!stopLoop);
    }
}
