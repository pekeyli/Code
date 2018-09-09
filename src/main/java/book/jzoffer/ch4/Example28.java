package book.jzoffer.ch4;

import java.util.Arrays;

/**
 * Created by pekey on 2017/12/22.
 */
public class Example28 {

    private static void permutation(char[] chars) {
        if(chars == null || chars.length<1){
            return;
        }
        permutation(chars,0);
    }

    private static void permutation(char[] chars, int begin) {
        if(chars.length-1 == begin)
            System.out.print(new String(chars)+ " ");
        else{
            char tmp;
            //对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
            for(int i = begin;i<chars.length;i++){
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;
                permutation(chars,begin+1);
            }
        }


    }

    //简单版本
    public static void all(char[] a, int start){
        if(start == a.length){
            System.out.println(Arrays.toString(a));
        }else {
            for (int i = start; i < a.length; ++i) {
                swap(a,start,i);
                all(a, start + 1);
                swap(a,start,i);
            }
        }
    }

    public static void swap(char[] a, int s, int i){
        char t = a[s];
        a[s] = a[i];
        a[i] = t;
    }

    //abc、acb、bac、bca、cab和cba
    public static void main(String[] args) {
        char[] c1 = {'a','b','c'};
        permutation(c1);

    }

}
