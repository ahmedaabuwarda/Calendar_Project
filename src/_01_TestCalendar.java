import java.util.InputMismatchException;
import java.util.Scanner;

public class _01_TestCalendar {

    public static void main(String[] args) throws InputMismatchException {

        _03_Help.help();
        readInput();

    }

    private static void readInput() throws InputMismatchException {

        Scanner input = new Scanner(System.in);

        try {

            System.out.print("\n >> Enter any year (e.g 2017): ");
            int year = input.nextInt();
            while (!_02_printCalendar.CheckYear(year)) {
                System.out.print(" >> Invalid Year, Please try again!\n" +
                        " >> Enter any year (e.g 2018 not -2001): ");
                year = input.nextInt();
            }

            System.out.print(" >> Enter any month (e.g 7): ");
            int month = input.nextInt();
            while (!_02_printCalendar.CheckMonth(month)) {
                System.out.print(" >> Invalid month, Please try again!\n" +
                        " >> Enter any month (e.g 11 not -7 or 15): ");
                month = input.nextInt();
            }

            _02_printCalendar.printMonth(year, month);
            System.out.println("\n---------------------------");

        } catch (InputMismatchException ex) {
            System.out.println("\n >> You entered an invalid year or month, please! try again!");
            readInput();
        }
    }
}