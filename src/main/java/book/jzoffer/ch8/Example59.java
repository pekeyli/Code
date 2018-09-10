package book.jzoffer.ch8;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example59 {

    boolean isSymmetrical(Tree pRoot) {
        return isSymmetrical(pRoot,pRoot);
    }

    //定义两个遍历，一个前序遍历，一个是和前序遍历相反的，先右后左的遍历
    boolean isSymmetrical(Tree pRoot1, Tree pRoot2) {
        if (pRoot1 == null && pRoot2 == null)
            return true;

        if (pRoot1 == null || pRoot2 == null)
            return false;

        if (pRoot1.val != pRoot2.val)
            return false;

        return isSymmetrical(pRoot1.left,pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }
    
}
