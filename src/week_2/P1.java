package week_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("./input/week2_input.txt"));
        Date[] dates = new Date[50];
        int index = 0;

        System.out.println("Birthdays:");
        while(scan.hasNextLine()) {
            dates[index++] = new Date(
                    scan.nextInt(),
                    scan.nextInt(),
                    scan.nextInt());

            System.out.println(dates[index-1].toString());
        }

        Date earlist = dates[0];
        Date latest = dates[0];

        for(int i=1; i<index; i++) {
            if(earlist.compareTo(dates[i]) == 1)
                earlist = dates[i];

            if(latest.compareTo(dates[i]) == -1)
                latest = dates[i];
        }

        System.out.println();
        System.out.println("Earlist birthday: " + earlist.toString());
        System.out.println("latest birthday: " + latest.toString());

        scan.close();
        scan = new Scanner(System.in);

        dates[49] = null;

        while(true) {
            System.out.println();
            System.out.print("Enter a birthday: ");
            int year = scan.nextInt();
            int month = scan.nextInt();
            int day = scan.nextInt();

            if(year == 0 && month == 0 && day == 0)
                break;

            Date current = new Date(year, month, day);

            int cnt = 0;
            for(int i=0; i<index; i++) {
                if(current.equals(dates[i]))
                    cnt++;
            }

            System.out.println("Number of the same birthday: " + cnt);
        }

        scan.close();
        System.out.println("-- End --");
    }
}
