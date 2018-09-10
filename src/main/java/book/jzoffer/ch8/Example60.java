package book.jzoffer.ch8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example60 {

    ArrayList<ArrayList<Integer>> Print(Tree pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        //使用队列，先进先出
        Queue<Tree> layer = new LinkedList<Tree>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        int start = 0, end = 1;//start记录本层打印了多少个，end记录下一层要打印多少个
        while(!layer.isEmpty()){
            Tree cur = layer.remove();
            layerList.add(cur.val);//添加本行打印的List里
            start++;
            //每打印一个节点，就把此节点的下一层的左右节点加入队列，并记录下一层要打印的个数
            if(cur.left!=null){
                layer.add(cur.left);
            }
            if(cur.right!=null){
                layer.add(cur.right);
            }
            //本层打印完毕
            if(start == end){
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }
    
}
