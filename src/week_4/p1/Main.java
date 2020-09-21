package week_4.p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        ArrayStack<Integer> stack = new ArrayStack<>();
        String command;
        int item;

        System.out.println("Enter a command: push, pop, peek, size, p(rint) or q(uit)");
        System.out.print("> ");
        command = in.next();

        while (true) {
            if (command.equals("push")) {
                item = in.nextInt();
                stack.push(item);
            }
            else if (command.equals("pop")) {
                stack.pop();
            }
            else if (command.equals("peek")) {
                item = stack.peek();
                System.out.println("Top element is " + item);
            }
            else if (command.equals("size")) {
                System.out.println("Size: " + stack.size());
            }
            else if (command.equals("p"))
                System.out.println(stack);
            else if (command.equals("m"))
                checkParenthesis();
            else if (command.equals("q")) {
                System.out.println("-- End --");
                break;
            }
            System.out.print("> ");
            command = in.next();
        }

        in.close();
    }

    public static void checkParenthesis() throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("./input/week4_input.txt"));
        ArrayStack<Character> stack = new ArrayStack<>();
        String line;

        Loop:
        while(inFile.hasNextLine()) {
            stack.clear();
            line = inFile.nextLine();

            for(int i=0; i<line.length(); i++) {
                char current = line.charAt(i);
                System.out.print(current);
                char check;

                switch(current) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(current);
                        continue;
                    case ')': check = '('; break;
                    case '}': check = '{'; break;
                    case ']': check = '['; break;
                    default: continue;
                }

                if(stack.isEmpty()) {
                    System.out.println("\nClosing parenthesis is not matched.\n");
                    continue Loop;
                }

                char prev = stack.pop();

                if(prev != check) {
                    System.out.println("\nParenthesis is not matched.\n");
                    continue Loop;
                }
            }

            if(!stack.isEmpty())
                System.out.println("\nOpening parenthesis is not matched.");
            else
                System.out.println("\nParentheses matched.");

            System.out.println();
        }
    }
}
