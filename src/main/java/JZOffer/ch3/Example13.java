package JZOffer.ch3;

/**
 * Created by pekey on 2017/12/20.
 * O(1)复杂度删除链表中元素，初步感觉只要理解思路即可
 */

class ListNode{
    int value;
    ListNode next;
}

public class Example13 {

    public static ListNode deleteNode(ListNode head,ListNode toBeDeleted){
        //如果输入参数有空值就返回表头结点
        if(head==null || toBeDeleted == null)
            return head;

        //如果删除的是表头节点，直接返回节点的下一个节点
        if(head == toBeDeleted)
            return head.next;

        //在对个节点的情况下.....
        if(toBeDeleted.next == null){
            //如果删除的是最后一个节点。先顺序查找到最后一个节点的前驱节点
            ListNode node = head;
            if(node.next != toBeDeleted){
                node = node.next;
            }
            //删除最后一个节点
            node.next = null;
        }else{
            //如果删除的是中间的某一个节点
            toBeDeleted.value = toBeDeleted.next.value; //将下一个节点的值赋值给当前待删除的节点
            toBeDeleted.next = toBeDeleted.next.next; //待删除的结点的下一个指向原先待删除引号的下下个结点，即将待删除的下一个结点删除
        }
        //返回删除后的头节点
        return head;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.value+"->");
            head = head.next;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;
        head.next = new ListNode();
        head.next.value = 2;
        head.next.next = new ListNode();
        head.next.next.value = 3;
        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;
        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;
        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;
        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;
        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;
        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;
        printList(head);
        System.out.println("----");
        head = deleteNode(head,head.next.next);
        printList(head);
    }
}
