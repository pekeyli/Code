package book.jzoffer.ch5;

import java.util.ArrayList;

/**
 * Created by pekey on 2017/12/26.
 */
public class Example34 {

    public static int getUglyNum(int n){
        if(n == 0)
            return 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while(res.size()<n){
            int m2 = res.get(i2)*2;
            int m3 = res.get(i3)*3;
            int m5 = res.get(i5)*5;
            int min = Math.min(m2,Math.min(m3,m5));
            res.add(min);
            if(min == m2)
                i2++;
            if(min == m3)
                i3++;
            if(min == m5)
                i5++;
        }
        return res.get(res.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(getUglyNum(15));
    }
}
