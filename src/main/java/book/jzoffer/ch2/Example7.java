package book.jzoffer.ch2;

import java.util.Stack;

/**
 * Created by pekey on 2017/12/18.
 */
public class Example7 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int data) {
        stack1.push(data);
    }

    public int pop() {
        while (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        Example7 emp = new Example7();
        emp.push(1);
        emp.push(2);
        System.out.println(emp.pop());
        System.out.println(emp.pop());
    }
}
