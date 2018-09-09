package ali.three;

import java.util.Arrays;

/**
 * Created by pekey on 2018/9/4.
 */

public class Main {

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

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c'};
        all(a, 0);
    }
}
