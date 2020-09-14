package week_2;

import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.print("Enter a row number: ");
            int rows = scan.nextInt();

            if(rows == 0)
                break;

            int[][] arr = new int[rows][];
            arr[0] = new int[1];
            arr[0][0] = 1;

            for(int i=1; i<arr.length; i++) {
                arr[i] = new int[i+1];
                for(int j=0; j<arr[i].length; j++) {
                    if(j==0 || j==arr[i].length-1)
                        arr[i][j] = 1;
                    else
                        arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }

            for(int[] arr1: arr) {
                for(int i: arr1)
                    System.out.print(i+"\t\t");
                System.out.println();
            }
        }

        scan.close();
        System.out.println("-- End --");
    }
}
