package week_6.p2;

public class Solution {

    public static int findSum(ArrayList<Integer> list) {
        int sum = 0;

        list.reset();
        while(list.hasNext())
            sum += list.next();

        return sum;
    }

    public static void oddNEven(ArrayList<Integer> list, ArrayList<Integer> oddList, ArrayList<Integer> evenList) {
        list.reset();
        while(list.hasNext()) {
            Integer current = list.next();

            if(current % 2 == 0)
                evenList.insert(current);
            else
                oddList.insert(current);
        }
    }
}
