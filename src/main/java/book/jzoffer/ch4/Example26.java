package book.jzoffer.ch4;

import java.util.HashMap;

/**
 * Created by pekey on 2017/12/22.
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Example26 {

    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode newHead = new RandomListNode(pHead.label);//复制链表的头结点

        RandomListNode pre = pHead, newPre = newHead;
        map.put(pre, newPre);

        //第一步，hashMap保存，原链表节点映射复制链表节点
        while (pre.next != null) {
            newPre.next = new RandomListNode(pre.next.label);
            pre = pre.next;
            newPre = newPre.next;
            map.put(pre, newPre);
        }

        //第二步：找到对应的random
        pre = pHead;
        newPre = newHead;

        while (newPre != null) {
            newPre.random = map.get(pre.random);
            pre = pre.next;
            newPre = newPre.next;
        }

        return newHead;
    }

    public static void main(String[] args) {

    }
}
