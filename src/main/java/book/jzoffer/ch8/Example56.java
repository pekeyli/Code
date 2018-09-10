package book.jzoffer.ch8;

/**
 * Created by pekey on 2018/1/3.
 */
class List{
    int data;
    List next;
}

public class Example56 {

    public List EntryNodeOfLoop(List pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        // 先判断是否有环
        List n1 = pHead;// 走一步
        List n2 = pHead;// 走两步
        List n = null;// 记录n1,n2碰面的点
        while (n2 != null && n2.next != null) {
            n2 = n2.next.next;
            n1 = n1.next;
            if (n2 == n1) {
                n = n2;// 记录碰头节点
                break;
            }
        }
        // 求出环中节点数量
        int num = 0;
        List temp = n;// n的镜像
        do {
            temp = temp.next;
            num++;
        } while (temp != n);

        List node1 = pHead;
        List node2 = pHead;
        // node1先走num步，然后node1,node2同时走，碰头的地方即入口节点
        for (int i = 0; i < num; i++) {
            node1 = node1.next;
        }
        int num1 = 0;

        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
            num1++;
        }
        return node1;
    }
    
}
