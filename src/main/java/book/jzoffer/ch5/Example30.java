package book.jzoffer.ch5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by pekey on 2017/12/25.
 */
public class Example30 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> leastNum = new ArrayList<Integer>();
        if (input == null || input.length < 1 || k < 1 || k > input.length)
            return leastNum;
        TreeSet<Integer> kSet = new TreeSet<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (kSet.size() < k) {
                kSet.add(input[i]);
            } else {
                if (input[i] < kSet.last()) {
                    kSet.remove(kSet.last());
                    kSet.add(input[i]);
                }
            }
        }
        Iterator<Integer> it = kSet.iterator();
        while (it.hasNext()) {
            leastNum.add(it.next());
        }

        return leastNum;
    }

    public static void main(String[] args) {

    }
}
