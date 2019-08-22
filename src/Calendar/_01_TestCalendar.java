/*
 * To change this template file, choose Settings | Editor | File and Code Templates
 * and change the template in the editor.
 */

package Calendar;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Ahmed Abuwarda.
 */
public class _01_TestCalendar {

    /**
     * @param args the command line arguments.
     */
    public static void main(String[] args) throws InputMismatchException {
        // TODO code application logic here.

        // Run The Program.
        _03_Help.help();
        readInput();

    }

    /**
     * @throws InputMismatchException Throws An Exception.
     */
    private static void readInput() throws InputMismatchException {

        // Create New Scanner.
        Scanner input = new Scanner(System.in);

        // Try Catch Block.
        try {

            System.out.print("\n >> Enter any year (e.g 2017): ");
            int year = input.nextInt();

            // While Loop.
            while (!_02_printCalendar.CheckYear(year)) {

                System.out.print(" >> Invalid Year, Please try again!\n" +
                        " >> Enter any year (e.g 2018 not -2001): ");
                year = input.nextInt();

            }

            System.out.print(" >> Enter any month (e.g 7): ");
            int month = input.nextInt();

            // While Loop.
            while (!_02_printCalendar.CheckMonth(month)) {

                System.out.print(" >> Invalid month, Please try again!\n" +
                        " >> Enter any month (e.g 11 not -7 or 15): ");
                month = input.nextInt();

            }

            // The Result.
            _02_printCalendar.printMonth(year, month);
            System.out.println("\n---------------------------");

        } catch (InputMismatchException ex) {
            System.err.println("\n >> You entered an invalid year or month, please! try again!");
            readInput();
        }

    }

}