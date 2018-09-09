package book.jzoffer.ch2;

import book.jzoffer.ch3.Example16;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by pekey on 2017/11/29.
 */
public class Example5 {

    public static void print(List ln){
        //基于栈来实现
        Stack<Integer> stack = new Stack<>();

        List currentNode = ln;

        while(currentNode != null){
            stack.push(currentNode.data);
            currentNode = currentNode.next;
        }

        while (!stack.isEmpty()){
            int tmp = stack.pop();
            System.out.println(tmp);
        }
    }

    public static void print2(List list){
        //递归实现
        if(list != null){
            if(list != null){
                print2(list.next);
            }
            System.out.println(list.data);
        }
    }

    public static void main(String[] args) {
        List head = new List();
        head.data = 1;
        head.next = new List();
        head.next.data = 2;
        head.next.next = new List();
        head.next.next.data = 3;
        head.next.next.next = new List();
        head.next.next.next.data = 4;
        head.next.next.next.next = new List();
        head.next.next.next.next.data = 5;
        head.next.next.next.next.next = new List();
        head.next.next.next.next.next.data = 6;
        head.next.next.next.next.next.next = new List();
        head.next.next.next.next.next.next.data = 7;
        head.next.next.next.next.next.next.next = new List();
        head.next.next.next.next.next.next.next.data = 8;
        head.next.next.next.next.next.next.next.next = new List();
        head.next.next.next.next.next.next.next.next.data = 9;

        //print(head);
        print2(head);
    }

}

class List{
    int data;
    List next;
}
