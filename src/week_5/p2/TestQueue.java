package week_5.p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestQueue {

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

    public static void categorize() throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("./input/week5_input.txt"));
        ArrayQueue<Integer> iQueue = new ArrayQueue<>();
        ArrayQueue<Double> dQueue = new ArrayQueue<>();
        ArrayQueue<String> sQueue = new ArrayQueue<>();

        while(inFile.hasNext()) {
            String str = inFile.next();
            if(isInteger(str))
                iQueue.enqueue(Integer.parseInt(str));
            else if(isDouble(str))
                dQueue.enqueue(Double.parseDouble(str));
            else
                sQueue.enqueue(str);
        }

        System.out.println("Integer: " + iQueue);
        System.out.println("Double: " + dQueue);
        System.out.println("String: " + sQueue);
    }

    /* Integer, Double 클래스 사용 */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* 아스키 코드 사용*/
    public static boolean isInteger_2(String str) {
        for(int i=0; i<str.length(); i++) {
            char current = str.charAt(i);
            if(current < '0' || current > '9')
                return false;
        }

        return true;
    }

    public static boolean isDouble_2(String str) {
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
