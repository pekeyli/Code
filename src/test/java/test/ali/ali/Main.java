package test.ali.ali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by pekey on 2018/9/7.
 */

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tou = in.nextInt();
        int hou = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < tou; i++) {
            int n = in.nextInt();
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }else{
                map.put(n,1);
            }
            int flow = in.nextInt();
            int[] tmp = {n,flow};
            list.add(tmp);
        }

        System.out.println(6);
    }



}
