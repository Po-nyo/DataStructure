package week_6.p2;

import java.util.Scanner;

public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        String command;
        int data;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a command: i(insert), r(emove). s(earch), size, ");
        System.out.println("p(rint), sum, c(odd or even),or q(uit)");
        System.out.print("> ");
        command = input.next();

        while (true) {
            if (command.equals("i")) {
                data = input.nextInt();
                list.insert(data);
            }
            else if (command.equals("r")) {
                data = input.nextInt();
                if (list.remove(data))
                    System.out.println(data + " removed.");
                else
                    System.out.println("No such " + data + "!");
            }
            else if (command.equals("s")) {
                data = input.nextInt();
                if (list.search(data))
                    System.out.println(data + " is in the list.");
                else
                    System.out.println("No such " + data + "!");
            }
            else if (command.equals("size")) {
                System.out.println("Size: " + list.size());
            }
            else if (command.equals("sum")) {
                int sum = Solution.findSum(list);
                System.out.println("Sum: " + sum);
            }
            else if (command.equals("c")) {
                ArrayList<Integer> oddList = new ArrayList<>();
                ArrayList<Integer> evenList = new ArrayList<>();
                Solution.oddNEven(list, oddList, evenList);
                System.out.println("odd number: " + oddList);
                System.out.println("even number: " + evenList);
            }
            else if (command.equals("p"))
                System.out.println(list);
            else if (command.equals("q"))
                break;

            System.out.print("> ");
            command = input.next();
        }
        System.out.println("-- End --");
        input.close();
    }
}
