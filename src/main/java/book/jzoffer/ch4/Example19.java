package book.jzoffer.ch4;

/**
 * Created by pekey on 2017/12/22.
 */
class Tree{
    int data;
    Tree left;
    Tree right;

    public Tree(){}

    public Tree(int data){
        this.data = data;
    }
}

public class Example19 {

    public static void mirroyRecursively(Tree node){
        if(node == null)
            return;
        if(node.left == null&&node.right == null)
            return;
        else{
            Tree temp;
            temp = node.left;
            node.left = node.right;
            node.right = temp;
            mirroyRecursively(node.left);
            mirroyRecursively(node.right);


        }
    }

    public static void printTree(Tree node){
        if(node != null){
            printTree(node.left);
            System.out.print(node.data+" ");
            printTree(node.right);
        }
    }


    public static void main(String[] args) {
        Tree root = new Tree(8);
        root.left = new Tree(6);
        root.right = new Tree(10);
        root.left.left = new Tree(5);
        root.left.right = new Tree(7);
        root.right.left = new Tree(9);
        printTree(root);
        System.out.println();
        mirroyRecursively(root);
        printTree(root);

    }


}
