package JZOffer.ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by pekey on 2017/11/29.
 */
public class Example5 {

    public static ArrayList<Integer> print(ListNode ln){
        Stack<ListNode> stack = new Stack<ListNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode currentNode = ln;
        while(currentNode != null){
            stack.push(currentNode);
            currentNode = currentNode.next;
        }
        while (stack.isEmpty()){
            list.add(new Integer(stack.pop().data));
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(3);
        System.out.println(print(ln));
    }

}

class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
