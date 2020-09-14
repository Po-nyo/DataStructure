package week_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./input/week1_input.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()) {
            Date myDate = new Date(
                    scan.nextInt(),
                    scan.nextInt(),
                    scan.nextInt());

            System.out.print(myDate.getYear()+": ");
            if(myDate.isLeap())
                System.out.println("윤년");
            else
                System.out.println("평년");
        }
    }
}
