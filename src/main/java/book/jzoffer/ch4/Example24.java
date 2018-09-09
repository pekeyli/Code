package book.jzoffer.ch4;

/**
 * Created by pekey on 2017/12/22.
 */
public class Example24 {

    private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if(start>=end)
            return true;
        //从左向右找第一个不大于根节点的元素的位置
        int index = start;

        while(index<end-1 && sequence[index]<sequence[end]){
            index++;
        }

        int right = index;
        while(index<end-1 && sequence[index]>sequence[end]){
            index++;
        }
        if(index != end-1){
            return false;
        }
        index = right;
        return verifySequenceOfBST(sequence,start,index-1) && verifySequenceOfBST(sequence,index,end-1);
    }

    public static void main(String[] args) {
        int[] data = {5,7,6,11,10,8};
        System.out.println(verifySequenceOfBST(data, 0, data.length-1));


    }

}
