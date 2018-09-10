package book.jzoffer.ch5;

import static java.lang.Math.max;

/**
 * Created by pekey on 2017/12/25.
 */
public class Example31 {
    public static int FindGreatestSumOfSubArray1(int[] array) {
        if(array.length==0)
            return 0;
        else{
            int total=array[0],maxSum=array[0];
            for(int i=1;i<array.length;i++){
                if(total>=0)
                    total+=array[i];
                else
                    total=array[i];
                if(total>maxSum)
                    maxSum=total;
            }
            return maxSum;
        }
    }

    public static int FindGreatestSumOfSubArray2(int[] array) {
        //动态规划，主要是找到状态转移方程
        //设f(j)是从s[0]到s[j]最大和
        //f(j) = max(s[j], f[j-1]+s[j])
        if(array.length == 0)
            return 0;
        int result = 0;
        int sum = 0;
        for(int i = 0; i < array.length; ++i)
        {
            sum = max(array[i], sum + array[i]);
            result = max(result, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3,5,6,-9,2,6,-22};
        System.out.println(FindGreatestSumOfSubArray2(a));
    }
}
