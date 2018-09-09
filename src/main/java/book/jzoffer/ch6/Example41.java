package book.jzoffer.ch6;

import java.util.ArrayList;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example41 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i=0,j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }

        }
        return list;
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (sum < 3)
            return list;
        ArrayList<Integer> l = new ArrayList<Integer>();
        int small = 2;
        int middle = (1 + sum) / 2;//因为至少连续2个且顺序增加，所以取中间值
        l.add(1);
        l.add(2);
        int s = 3;
        if (s == sum) {
            list.add(new ArrayList<Integer>(l));
        }

        while (small <= middle) {
            small++;
            s += small;
            l.add(small);
            if (s == sum) {
                list.add(new ArrayList<Integer>(l));
            }
            //两个指针，若大，减去左边数字，若小，加右边数字
            while (s > sum && small <= middle) {
                s -= l.remove(0);
                if (s == sum) {
                    list.add(new ArrayList<Integer>(l));
                }
            }

        }
        return list;
    }
}
