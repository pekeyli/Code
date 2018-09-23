package test.ali.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    }

    public static int share(int child){
        if(child == 10)
            return 2;
        return (share(child + 1) + 1) << 1;
    }

    public static List tran(int total, int[] prices){
        LinkedList<Integer> res = new LinkedList<>();
        Arrays.sort(prices);
        for(int i = prices.length - 1; total > 0 && i >= 0; i--){
            while(prices[i] <= total){
                total -= prices[i];
                res.offerFirst(prices[i]);
            }
        }
        return total == 0 ? res : null;
    }


}