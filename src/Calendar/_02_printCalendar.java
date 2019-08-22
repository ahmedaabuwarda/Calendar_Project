/*
 * To change this template file, choose Settings | Editor | File and Code Templates
 * and change the template in the editor.
 */

package Calendar;

/**
 * @author Ahmed Abuwarda.
 */
class _02_printCalendar {

    /**
     * @param year  Enter Any Year.
     * @param month Enter Any Month.
     */
    static void printMonth(int year, int month) {

        getMonthTitle(year, month);
        printMonthBody(year, month);

    }

    /**
     * @param year  Any Year.
     * @param month Any Month.
     */
    private static void getMonthTitle(int year, int month) {

        getMonthName(month);
        System.out.println("\t" + year +
                "\n---------------------------\n" +
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat");

    }

    /**
     * @param month Any Month.
     */
    private static void getMonthName(int month) {

        String[] months = {"January", "February", "March", "April", "May", "June", "July"
                , "August", "Septemper", "Octoper", "Novemper", "Decemper"};
        System.out.print("\n\t" + months[month - 1]);

    }

    /**
     * @param year  Any Year.
     * @param month Any Month.
     */
    private static void printMonthBody(int year, int month) {

        getStartDay(year, month);
        getTotalNumOfDays(year, month);

    }

    /**
     * Get The First Day In The Month.
     *
     * @param year  Any Year.
     * @param month Any Month.
     */
    private static void getStartDay(int year, int month) {

        int StartDay = WhatDayInWeek(year, month, 1);
        String FirstTab = "1", Tap = "\t";

        // For Loop
        for (int i = 1; i < StartDay; i++) {

            // FirstTab = "\t" + FirstTab;
            FirstTab = Tap.concat(FirstTab);

        }

        // If Statement.
        if (StartDay == 0) {
            FirstTab = "\t\t\t\t\t\t1";
        }

        // Print The First Day In This Month.
        System.out.print(FirstTab + "\t");

    }

    /**
     * Here we find the day that month starts with using Zeller's Algorithm.
     *
     * @param year          Any Year.
     * @param month         Any Month
     * @param NumDayOfMonth Method.
     * @return NumDayOfMonth = (1 ,2 ,3 , ... , 28 or 29 or 30 or 31).
     */
    private static int WhatDayInWeek(int year, int month, int NumDayOfMonth) {

        if (month == 1 || month == 2) {

            month = (month == 1) ? 13 : 14;
            year--;

        }

        return (NumDayOfMonth + (26 * (month + 1) / 10) + (year % 100) +
                (year % 100) / 4 + (year / 100) / 4 + (5 * year / 100)) % 7;

    }

    /**
     * @param year  Any Year.
     * @param month Any Month.
     */
    private static void getTotalNumOfDays(int year, int month) {

        // Length of month == lastDay.
        int lastDay = getNumOfDaysInMonth(month, year);

        // Print The Rest Of Calendar "Using For Loop".
        for (int i = 2; i <= lastDay; i++) {

            int StartDay = WhatDayInWeek(year, month, i);

            // To Divide The Month Into 7 Days For Each Line "Using If Statement".
            if (StartDay == 1) System.out.println();

            System.out.print(i + "\t");

        }

    }

    /**
     * @param month Any Month.
     * @param year  Any Year.
     * @return monthDays "To Know How Many Days In Any Month In Any Year Either It Is Leap Or Not".
     */
    private static int getNumOfDaysInMonth(int month, int year) {

        int monthDays;

        // If Statement.
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            monthDays = 30;
        } else if (month == 2) {
            monthDays = isLeapYear(year) ? 29 : 28;
        } else {
            monthDays = 31;
        }

        return monthDays;

    }

    /**
     * @param year Any Year.
     * @return Is LeapYear Or Not.
     */
    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    /**
     * @param year Any Year.
     * @return If The Year Between 0 and 10001.
     */
    static boolean CheckYear(int year) {
        return 10001 > year && year > 0;
    }

    /**
     * @param month Any Month.
     * @return If The Month Between 0 and 13.
     */
    static boolean CheckMonth(int month) {
        return 0 < month && month < 13;
    }

}