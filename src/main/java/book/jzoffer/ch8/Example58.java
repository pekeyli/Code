package book.jzoffer.ch8;

/**
 * Created by pekey on 2018/1/3.
 */

class Tree {
    int val;
    Tree left = null;
    Tree right = null;
    Tree parent= null;

    Tree(int val) {
        this.val = val;
    }
}

public class Example58 {
    Tree GetNext(Tree node)
    {
        if(node==null) return null;
        if(node.right!=null){    //如果有右子树，则找右子树的最左节点
            node = node.right;
            while(node.left!=null) node = node.left;
            return node;
        }
        while(node.parent!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(node.parent.left==node) return node.parent;
            node = node.parent;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }
}
