package book.jzoffer.ch3;

/**
 * Created by pekey on 2017/12/21.
 */
public class Example17 {
    public static class List {
        int data;
        List next;
    }

    public static List mergeList(List pHead1, List pHead2) {
        //非递归
        List mergeHead = null;
        if (pHead1 == null)
            return pHead2;
        else if (pHead2 == null)
            return pHead1;
        else {
            //创建一个临时节点，用户添加元素时方便
            List root = new List();
            //用于指向合并后的新链的尾节点
            List pointer = root;
            //当两个链表都不为空就进行合并操作
            while (pHead1 != null && pHead2 != null) {
                if (pHead1.data > pHead2.data) {
                    pointer.next = pHead2;
                    pHead2 = pHead2.next;
                } else {
                    pointer.next = pHead1;
                    pHead1 = pHead1.next;
                }
                pointer = pointer.next;
            }
            if (pHead1 != null) {
                pointer.next = pHead1;
            }
            if (pHead2 != null) {
                pointer.next = pHead2;
            }

            return root.next;
        }

    }

    public static List merge(List a, List b){
        //递归
        List head;
        if(a == null){
            return b;
        }else if(b == null){
            return a;
        }else{
            if(a.data < b.data){
                head = a;
                head.next = merge(a.next, b);
            }else{
                head = b;
                head.next = merge(a, b.next);
            }
        }
        return head;
    }

    public static void printList(List head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
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
        List head2 = new List();
        head2.data = 1;
        head2.next = new List();
        head2.next.data = 3;
        head2.next.next = new List();
        head2.next.next.data = 5;
        head2.next.next.next = new List();
        head2.next.next.next.data = 6;
        head2.next.next.next.next = new List();
        head2.next.next.next.next.data = 7;
        head = merge(head, head2);
        printList(head);

    }

}
