import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int j = 1; j <= n; j++) {
                ArrayList<Integer> list = new ArrayList<>();
                map.put(j, list);
            }
            for (int j = 0; j < m; j++) {
                int first = sc.nextInt();
                int sec = sc.nextInt();
                ArrayList<Integer> listFirst = map.get(first);
                listFirst.add(sec);
                ArrayList<Integer> listSec = map.get(sec);
                listSec.add(first);
            }

            System.out.println(solve(map));
        }
        sc.close();
    }

    public static String solve(HashMap<Integer, ArrayList<Integer>> map) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> single = new ArrayList<>();
        
        for (int i = 1; i <= map.size(); i++) {
            single.add(i);
            ArrayList<Integer> list = map.get(i);
            for (int j = 1; j <= map.size(); j++) {
                if (j != i) {
                    if (!list.contains(j))
                        single.add(j);
                }
            }
            Collections.sort(single);

            if (!result.contains(single))
                result.add(new ArrayList<>(single));
            single.clear();
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (!Collections.disjoint(result.get(i), result.get(j))) {
                    return "No";
                }
            }
        }

        return "Yes";

    }
}