package JZOffer.ch2;

import apple.laf.JRSUIUtils;

/**
 * Created by pekey on 2017/11/29.
 */
public class Example6 {

    public static TreeNode reConstructBinaryTree(int[] pre,int[] in){
        TreeNode treeNode = reConstruct(pre,0,pre.length-1,in,0,in.length-1);
        return treeNode;
    }

    public static TreeNode reConstruct(int[] pre,int startpre,int endpre,int[] in,int startIn,int endIn) {
        if(startpre>endpre || startIn>endIn)
            return null;
        TreeNode root = new TreeNode(pre[startpre]);
        for(int i =startIn;i<endIn;i++){
            if(pre[startpre] == in[i]){
                root.left =reConstruct(pre, startpre+1, startpre+i-startIn, in, startIn, i-1);
                root.right=reConstruct(pre, i-startIn+startpre+1, endpre, in, i+1, endIn);
            }

        }
        return root;
    }

    public static void main(String [] args){
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre,in);
        System.out.println(node.data);

    }
}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
 }
