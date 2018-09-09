package book.jzoffer.ch2;

/**
 * Created by pekey on 2017/11/29.
 */
public class Example6 {
    //前序和中序重构二叉树

    public static Tree reConstructBinaryTree(int[] pre, int[] in) {
        Tree Tree = reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return Tree;
    }

    public static Tree reConstruct(int[] pre, int startpre, int endpre, int[] in, int startIn, int endIn) {
        if (startpre > endpre || startIn > endIn)
            return null;

        Tree root = new Tree(pre[startpre]);

        for (int i = startIn; i < endIn; i++) {
            if (pre[startpre] == in[i]) {
                root.left = reConstruct(pre, startpre + 1, startpre + i - startIn, in, startIn, i - 1);
                root.right = reConstruct(pre, i - startIn + startpre + 1, endpre, in, i + 1, endIn);
            }

        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Tree node = reConstructBinaryTree(pre, in);
        System.out.println(node.data);

    }
}

class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
