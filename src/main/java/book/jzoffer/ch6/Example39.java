package book.jzoffer.ch6;

/**
 * Created by pekey on 2018/1/3.
 */

class Tree {
    int val = 0;
    Tree left = null;
    Tree right = null;

    public Tree(int val) {
        this.val = val;
    }
};

public class Example39 {

    //是否是平衡二叉树
    public boolean IsBalanced(Tree root) {
        if (root == null)
            return true;

        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
            return false;


        return IsBalanced(root.left) && IsBalanced(root.right);

    }

    //改进版
    public boolean IsBalanced2(Tree root) {
        int depth = 0;
        return IsBalanced2(root, depth);
    }

    public boolean IsBalanced2(Tree root, int depth) {
        if (root == null) {
            depth = 0;
            return true;
        }

        int left = 0, right = 0;
        if (IsBalanced2(root.left, left) && IsBalanced2(root.right, right)) {
            int diff = left - right;
            if (diff <= 1 && diff >= -1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }

        return false;
    }

    public int getHeight(Tree root) {
        if (root == null)
            return 0;
        return max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {

    }

}
