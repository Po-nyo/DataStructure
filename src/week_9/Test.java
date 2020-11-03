package week_9;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();
        String command;
        int data;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a command: i(nsert), s(earch), r(emove), inorder,\n"
                + "h(eight), nc(node count), lc(leaf count), p(rint), or q(uit)");
        while (true) {
            System.out.print("> ");
            command = in.next();
            if (command.equals("i")) {
                data = in.nextInt();
                if (tree.insert(data))
                    System.out.println(data + " inserted.");
                else
                    System.out.println(data + " is already in the tree!");
            }
            else if (command.equals("s")) {
                data = in.nextInt();
                if (tree.search(data))
                    System.out.println(data + " is in the tree.");
                else
                    System.out.println("No such " + data + "!");
            }
            else if (command.equals("r")) {
                data = in.nextInt();
                if (tree.remove(data))
                    System.out.println(data + " removed.");
                else
                    System.out.println("No such " + data + "!");
            }
            else if (command.equals("inorder"))
                tree.inorderTraverse();
            else if (command.equals("h"))
                System.out.println("Tree height: " + tree.height());
            else if (command.equals("nc"))
                System.out.println("Node count: " + tree.countNodes());
            else if (command.equals("lc"))
                System.out.println("Leaf count: "+ tree.countLeaves());
            else if (command.equals("p")) {
                tree.print();
            }
            else if (command.equals("q")) {
                System.out.println("—End --");
                break;
            }
        }
        in.close();
    }
}
