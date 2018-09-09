package book.jzoffer.ch4;

import java.util.Stack;

/**
 * Created by pekey on 2017/12/22.
 */
public class Example22 {
    public static boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || pop.length == 0 || push.length == 0 || pop.length != push.length)
            return false;

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;

        while (popIndex < pop.length) {
            while (pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) {
                stack.push(push[pushIndex]);
                pushIndex++;
            }
            if (stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 1, 2};
        System.out.println(isPopOrder(push, pop));

    }

}
