package week_3.p2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.print("Enter a row number: ");
            int rows = scan.nextInt();

            if(rows == 0)
                break;

            Node[] pascal = new Node[rows];

            makeTriangle(pascal, rows);
            print(pascal);
        }

        scan.close();
        System.out.println("-- End --");
    }

    public static void makeTriangle(Node[] pascal, int rows) {
        for(int i=0; i<pascal.length; i++) {
            pascal[i] = new Node(1);
            Node prev = pascal[i];

            for(int j=2; j<=i+1; j++) {
                if(j == i+1) {
                    prev.next = new Node(1);
                }
                else {
                    int currentNum = selectNth(pascal[i-1], j-1).item + selectNth(pascal[i-1], j).item;
                    prev.next = new Node(currentNum);
                }
                prev = prev.next;
            }
        }
    }

    public static Node selectNth(Node node, int n) {
        Node temp = node;

        for(int i=1; i<n; i++)
            temp = temp.next;

        return temp;
    }

    public static void print(Node[] heads) {
        for(Node node: heads) {
            Node temp = node;

            while(temp != null) {
                System.out.print(temp.item + "\t");
                temp = temp.next;
            }

            System.out.println();
        }
    }
}
