package book.jzoffer.ch3;

/**
 * Created by pekey on 2017/12/21.
 */

class ListNodeK{
    int data;
    ListNodeK next;

    public ListNodeK(int data) {
        this.data = data;
    }
}

public class Example15 {

    public static ListNodeK findBottonK(ListNodeK head,int k){
        if(head == null)
            throw new RuntimeException("链表为空");
        if(k==0)
            throw new RuntimeException("请正确输入k的值");

        ListNodeK firstNode = head;
        ListNodeK secondNode = head;

        for(int i =0;i<k-1;i++){
            if(firstNode.next != null)
                firstNode = firstNode.next;
            else
                return null;
        }
        while(firstNode.next != null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return secondNode;
    }

    public static void main(String[] args) {
        ListNodeK head = new ListNodeK(1);
        head.next = new ListNodeK(2);
        head.next.next = new ListNodeK(3);
        head.next.next.next = new ListNodeK(4);
        ListNodeK middle = head.next.next.next.next = new ListNodeK(5);
        ListNodeK node = findBottonK(head,0);
        System.out.println(node.data);
    }
}
