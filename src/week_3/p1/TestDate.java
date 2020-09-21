package week_3.p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestDate {

    public static void main(String[] args) throws FileNotFoundException {
        int year, month, day;

        Date date;

        Node headFirst = null;
        Node headLast = null;
        Node headOrder = null;

        Scanner inFile = new Scanner(new File("./input/week3_input.txt"));

        while (inFile.hasNextLine()) {
            year = inFile.nextInt();
            month = inFile.nextInt();
            day = inFile.nextInt();

            date = new Date(year, month, day);

            headFirst = insertFirst(headFirst, date);
            headLast = insertLast(headLast, date);
            headOrder = insertSortedOrder(headOrder, date);
        }

        inFile.close();

        System.out.println("Insertion in first: ");
        print(headFirst);
        System.out.println("Insertion in last: ");
        print(headLast);
        System.out.println("Insertion in sorted order: ");
        print(headOrder);
    }

    public static Node insertFirst(Node headFirst, Date date) {
        return headFirst = new Node(date, headFirst);
    }

    public static Node insertLast(Node headLast, Date date) {
        Node newNode = new Node(date);

        if(headLast == null)
            headLast = newNode;
        else {
            Node last = headLast;

            while (last.next != null)
                last = last.next;

            last.next = newNode;
        }

        return headLast;
    }

    public static Node insertSortedOrder(Node headOrder, Date date) {
        Node newNode = new Node(date);

        if(headOrder == null)
            headOrder = newNode;
        else {
            if(date.compareTo(headOrder.item) == -1)
                return insertFirst(headOrder, date);
            else {
                Node current = headOrder;

                while(current.next != null) {
                    if(date.compareTo(current.next.item) < 0) {
                        newNode.next = current.next;
                        current.next = newNode;
                        return headOrder;
                    }
                    current = current.next;
                }

                current.next = newNode;
            }
        }
        return headOrder;
    }

    public static void print(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.println(temp.item.toString());
            temp = temp.next;
        }

        System.out.println();
    }
}
