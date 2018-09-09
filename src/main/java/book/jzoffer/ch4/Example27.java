package book.jzoffer.ch4;

/**
 * Created by pekey on 2017/12/22.
 */


public class Example27 {
    Tree head = null;
    Tree realHead = null;//双向链表的头结点

    public Tree Convert(Tree pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return realHead;
    }

    public static void main(String[] args) {

    }
}
