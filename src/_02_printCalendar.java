class _02_printCalendar {

    static void printMonth(int year, int month) {
        getMonthTitle(year, month);
        printMonthBody(year, month);
    }

    private static void getMonthTitle(int year, int month) {
        getMonthName(month);
        System.out.println("\t" + year +
                "\n---------------------------\n" +
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat");
    }

    private static void getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July"
                , "August", "Septemper", "Octoper", "Novemper", "Decemper"};
        System.out.print("\n\t" + months[month - 1]);
    }

    private static void printMonthBody(int year, int month) {

        getStartDay(year, month);
        getTotalNumOfDays(year, month);

    }

    // Get the first day in the month
    private static void getStartDay(int year, int month) {
        int StartDay = WhatDayInWeek(year, month, 1);
        String FirstTab = "1", Tap = "\t";
        for (int i = 1; i < StartDay; i++) {
            // FirstTab = "\t" + FirstTab;
            FirstTab = Tap.concat(FirstTab);
        }
        if (StartDay == 0) {
            FirstTab = "\t\t\t\t\t\t1";
        }
        System.out.print(FirstTab + "\t");
    }

    // Here we find the day that month starts with using Zeller's Algorithm
    // NumDayOfMonth = (1 ,2 ,3 , ... , 28 or 29 or 30 or 31)
    private static int WhatDayInWeek(int year, int month, int NumDayOfMonth) {
        if (month == 1 || month == 2) {
            month = (month == 1) ? 13 : 14;
            year--;
        }
        return (NumDayOfMonth + (26 * (month + 1) / 10) + (year % 100) +
                (year % 100) / 4 + (year / 100) / 4 + (5 * year / 100)) % 7;
    }

    private static void getTotalNumOfDays(int year, int month) {
        // Length of month == lastDay
        int lastDay = getNumOfDaysInMonth(month, year);
        // Print the rest of calendar
        for (int i = 2; i <= lastDay; i++) {
            int StartDay = WhatDayInWeek(year, month, i);
            // To divide the month into 7 days for each line
            if (StartDay == 1) {
                System.out.println();
            }
            System.out.print(i + "\t");
        }
    }

    // To know how many days in any month in any year either it is leap or not.
    private static int getNumOfDaysInMonth(int month, int year) {
        int monthDays;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            monthDays = 30;
        } else if (month == 2) {
            monthDays = isLeapYear(year) ? 29 : 28;
        } else {
            monthDays = 31;
        }
        return monthDays;
    }

    // To check the validation of any leap year.
    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    // To check the validation of any year.
    static boolean CheckYear(int year) {
        return 10001 > year && year > 0;
    }

    // To check the validation of any month.
    static boolean CheckMonth(int month) {
        return 0 < month && month < 13;
    }
}