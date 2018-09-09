package book.jzoffer.ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pekey on 2017/12/22.
 */
public class Example25 {

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

    public static void FindPath(Tree root, int expectedSum){
        List<Integer> list = new ArrayList();
        if(root != null)
            FindPath(root, expectedSum, 0, list);
    }

    public static void FindPath(Tree root,int expectedSum,int curSum,List<Integer> list){
        if(root != null){
            curSum += root.data;
            list.add(root.data);

            if(curSum<expectedSum){
                FindPath(root.left, expectedSum, curSum, list);
                FindPath(root.right, expectedSum, curSum, list);
            }else if(curSum==expectedSum){
                if(root.left == null && root.right == null){
                    System.out.println(curSum);
                }
            }
            list.remove(list.size()-1);
        }

    }


    public static void main(String[] args) {
        Tree root = new Tree(10);
        root.left = new Tree(5);
        root.right = new Tree(12);
        root.left.left = new Tree(4);
        root.left.right = new Tree(7);
        FindPath(root,22);


    }

}

