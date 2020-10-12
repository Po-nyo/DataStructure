package week_7.p1;

import java.util.Scanner;

public class TestSortedArrayList {

    public static void main(String[] args) {
        SortedArrayList<Integer> list = new SortedArrayList<Integer>();
        String command;
        int item;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a command: i(insert), r(emove). s(earch), size, p(rint), or q(uit)");
        System.out.print("> ");
        command = input.next();

        while (true) {
            if (command.equals("i")) {
                item = input.nextInt();
                list.insert(item);
            } else if (command.equals("r")) {
                item = input.nextInt();
                if (list.remove(item))
                    System.out.println(item + " removed.");
                else
                    System.out.println("No such " + item + "!");
            } else if (command.equals("s")) {
                item = input.nextInt();
                if (list.search(item))
                    System.out.println(item + " is in the list.");
                else
                    System.out.println("No such " + item + "!");
            } else if (command.equals("size")) {
                System.out.println("Size: " + list.size());
            } else if (command.equals("p"))
                System.out.println(list);
            else if (command.equals("q")) {
                break;
            }
            System.out.print("> ");
            command = input.next();
        }
    }
}
