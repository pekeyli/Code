package book.jzoffer.ch3;

/**
 * Created by pekey on 2017/12/21.
 */
public class Example18 {
    public static class Tree{
        int data;
        Tree left;
        Tree right;
    }

    public static boolean hasSubTree(Tree root1,Tree root2){
        if(root1 ==root2)
            return true;
        else if(root1 == null)
            return false;
        else if(root2 == null)
            return true;
        else{
            boolean flag = false;
            if(root1.data == root2.data)
                flag = isSubTree(root1,root2);
            if(flag)
                return true;
            else
                return isSubTree(root1.left,root2) || isSubTree(root1,root2.right);
        }
    }

    private static boolean isSubTree(Tree root1,Tree root2) {
        if(root1 ==root2)
            return true;
        else if(root1 == null)
            return false;
        else if(root2 == null)
            return true;
        else{
            if(root1.data == root2.data)
                return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
            else
                return false;
        }
    }

    public static void main(String[] args) {
        Tree root1 = new Tree();
        root1.data = 8;

        root1.left = new Tree();
        root1.left.data = 8;
        root1.right = new Tree();
        root1.right.data = 7;

        root1.left.left = new Tree();
        root1.left.left.data = 9;
        root1.left.right = new Tree();
        root1.left.right.data = 2;

        root1.left.right.left = new Tree();
        root1.left.right.left .data = 4;
        root1.left.right.right = new Tree();
        root1.left.right.right.data = 7;


        Tree root2 = new Tree();
        root2.data = 8;

        root2.left = new Tree();
        root2.left.data = 9;

        root2.right = new Tree();
        root2.right.data = 2;

        System.out.println(hasSubTree(root1, root2));
        System.out.println(hasSubTree(root2, root1));
        System.out.println(hasSubTree(root1, root1.left));
        System.out.println(hasSubTree(root1, null));
        System.out.println(hasSubTree(null, root2));
        System.out.println(hasSubTree(null, null));

    }

}
