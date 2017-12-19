package JZOffer.ch2;

import java.util.Stack;

/**
 * Created by pekey on 2017/12/18.
 */
public class Example7 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int data){
        stack1.push(data);
    }

    public int pop_my(){
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();

    }
}
