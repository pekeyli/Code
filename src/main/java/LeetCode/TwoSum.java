package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pekey on 2018/7/21.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int target = 20;
        int[] res = twoSum(a, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int x = 0; x < nums.length - 2; x++){
            for(int y = x +1; y < nums.length - 1; y++){
                for (int z = y+1; z < nums.length; z++) {
                    if(nums[x]+nums[y]+nums[z]==target){
                        list.add(x);
                        list.add(y);
                        list.add(z);
                        int[] res = new int[list.size()];
                        for(int i = 0; i<list.size(); i++){
                            res[i] = list.get(i);
                        }
                        return res;
                    }
                }
            }
        }
        return null;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int x = 0; x < nums.length - 2; x++){
            for(int y = x +1; y < nums.length - 1; y++){
                for (int z = y+1; z < nums.length; z++) {
                    if(nums[x]+nums[y]+nums[z]==0){
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[x]);
                        tmp.add(nums[y]);
                        tmp.add(nums[z]);
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
}
