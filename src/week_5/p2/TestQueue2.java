package week_5.p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestQueue2 {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        String command;
        int item;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a command: e(nqueue), d(equeue), s(ize), peek, p(rint), c(categorize), or q(uit)");
        System.out.print("> ");
        command = in.next();

        while (true) {
            if (command.equals("e")) {
                item = in.nextInt();
                queue.enqueue(item);
            }
            else if (command.equals("d")) {
                queue.dequeue();
            }
            else if (command.equals("s"))
                System.out.println("Size: " + queue.size());
            else if (command.equals("peek"))
                System.out.println("Front of the queue: " +
                        queue.peek());
            else if (command.equals("p"))
                System.out.println(queue);
            else if (command.equals("c"))
                categorize();
            else if (command.equals("q")) {
                System.out.println("-- End --");
                break;
            }
            System.out.print("> ");
            command = in.next();
        }
        in.close();
    }

    /* Integer, Double 클래스 사용x */
    public static void categorize() throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("./input/week5_input.txt"));
        ArrayQueue<Integer> iQueue = new ArrayQueue<>();
        ArrayQueue<Double> dQueue = new ArrayQueue<>();
        ArrayQueue<String> sQueue = new ArrayQueue<>();

        while(inFile.hasNext()) {
            String str = inFile.next();
            if(isInteger(str))
                iQueue.enqueue(TypeConversion.String2Int(str));
            else if(isDouble(str))
                dQueue.enqueue(TypeConversion.String2Double(str));
            else
                sQueue.enqueue(str);
        }

        System.out.println("Integer: " + iQueue);
        System.out.println("Double: " + dQueue);
        System.out.println("String: " + sQueue);
    }

    public static boolean isInteger(String str) {
        for(int i=0; i<str.length(); i++) {
            char current = str.charAt(i);
            if(current < '0' || current > '9')
                return false;
        }

        return true;
    }

    public static boolean isDouble(String str) {
        int count = 0;

        for(int i=0; i<str.length(); i++) {
            char current = str.charAt(i);

            if(current == '.')
                count++;
            else if (current < '0' || current > '9')
                    return false;
        }

        return count <= 1;
    }
}
