package book.jzoffer.ch4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pekey on 2017/12/22.
 */
public class Example23 {

    public static class Tree{
        int data;
        Tree left;
        Tree right;
        public Tree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }


    }

    public static void printFromToBottom(Tree root){
        if(root != null){
            Queue<Tree> list = new LinkedList<>();
            list.add(root);
            //用于记录当前处理的结点
            Tree curNode;
            //队列非空则进行处理
            while(!list.isEmpty()){
                //删除队首元素
                curNode = list.remove();
                System.out.print(curNode.data+" ");
                if(curNode.left != null){
                    list.add(curNode.left);
                }
                if(curNode.right != null){
                    list.add(curNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(8);
        root.left = new Tree(6);
        root.right = new Tree(10);
        root.left.left = new Tree(5);
        root.left.right = new Tree(7);
        root.right.left = new Tree(9);
        root.right.right = new Tree(11);
        printFromToBottom(root);

    }

}
