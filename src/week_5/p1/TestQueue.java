package week_5.p1;

import java.util.Scanner;

public class TestQueue {

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        String command;
        int item;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a command: e(nqueue), d(equeue), s(ize), peek, sort, p(rint), or q(uit)");
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

            else if (command.equals("sort"))
                radixSort();
            else if (command.equals("q")) {
                System.out.println("-- End --");
                break;
            }
            System.out.print("> ");
            command = in.next();
        }
        in.close();
    }

    public static void radixSort() {
        final int MAX_SIZE = 20;
        final int DIGITS = 4;
        int radix = 10;
        LinkedQueue<Integer>[] queues = new LinkedQueue[radix];
        for(int i=0; i<queues.length; i++)
            queues[i] = new LinkedQueue();

        int[] randoms = generateNumbers(MAX_SIZE, DIGITS);

        System.out.print("정렬되지 않은 데이터: \t");
        printArray(randoms);

        for(int i=0; i<DIGITS; i++) {
            int currentDigits = (int)Math.pow(10, i);
            for(int j: randoms) {
                int digit = (j % (currentDigits * 10)) / currentDigits;
                queues[digit].enqueue(j);
            }
            rebuild(randoms, queues);
            System.out.printf("%5d자리 정렬: \t\t", currentDigits);
            printArray(randoms);
        }
    }

    public static int[] generateNumbers(int size, int digits) {
        int[] items = new int[size];

        for(int i=0; i<items.length; i++)
            items[i] = (int)(Math.random() * Math.pow(10, digits));

        return items;
    }

    public static void rebuild(int[] array, LinkedQueue<Integer>[] queues) {
        int idx = 0;

        for (LinkedQueue<Integer> queue: queues) {
            while (!queue.isEmpty())
                array[idx++] = queue.dequeue();
        }
    }

    public static void printArray(int[] array) {
        for(int i: array)
            System.out.print(i + " ");
        System.out.println();
    }
}
