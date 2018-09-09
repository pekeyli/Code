package book.jzoffer.ch5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by pekey on 2017/12/26.
 */
public class Example33 {
    public static String PrintMin(int[] array){
        if(array == null ||array.length<1){
            throw new IllegalArgumentException("Array must contain value");
        }
        int len = array.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len ; i++) {
            str[i] = String.valueOf(array[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] a = {3,32,421};
        System.out.println(PrintMin(a));
    }
}
