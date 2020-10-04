package week_6.p1;

import java.util.Scanner;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        String command;
        int item, num;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a command: i(insert), r(emove), s(earch), size, append, ");
        System.out.println("insert, delete, reverse, p(rint), or q(uit)");
        System.out.print("> ");
        command = input.next();

        while (true) {
            if (command.equals("i")) {
                item = input.nextInt();
                list.insert(item);
            }
            else if (command.equals("r")) {
                item = input.nextInt();
                if (list.remove(item))
                    System.out.println(item + " removed.");
                else
                    System.out.println("No such " + item + "!");
            }
            else if (command.equals("s")) {
                item = input.nextInt();
                if (list.search(item))
                    System.out.println(item + " is in the list.");
                else
                    System.out.println("No such " + item + "!");
            }
            else if (command.equals("size")) {
                System.out.println("Size: " + list.size());
            }
            else if (command.equals("p"))
                System.out.println(list);
            else if (command.equals("insert")) {
                num = input.nextInt();
                item = input.nextInt();
                list.insert(num, item);
            }
            else if (command.equals("delete")) {
                num = input.nextInt();
                list.delete(num);
            }
            else if (command.equals("append")) {
                item = input.nextInt();
                list.append(item);
            }
            else if (command.equals("retrieve")) {
                num = input.nextInt();
                item = list.retrieve(num);
                System.out.println(item);
            }
            else if (command.equals("q"))
                break;
            System.out.print("> ");
            command = input.next();
        }
        System.out.println("-- End --");
        input.close();
    }
}
