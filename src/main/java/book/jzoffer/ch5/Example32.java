package book.jzoffer.ch5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by pekey on 2017/12/25.
 */
public class Example32 {

    public int NumberOf1Between1AndN_Solution(int n) {
        //当x=1时
        return NumberOfXBetween1AndN_Solution1(n,1);
    }

    public int NumberOfXBetween1AndN_Solution1(int n,int x) {
        if(n<0||x<1||x>9)
            return 0;
        int high,low,curr,tmp,i = 1;
        high = n;
        int total = 0;
        while(high!=0){
            high = n/(int)Math.pow(10, i);// 获取第i位的高位
            tmp = n%(int)Math.pow(10, i);
            curr = tmp/(int)Math.pow(10, i-1);// 获取第i位
            low = tmp%(int)Math.pow(10, i-1);// 获取第i位的低位
            if(curr==x){
                total+= high*(int)Math.pow(10, i-1)+low+1;
            }else if(curr<x){
                total+=high*(int)Math.pow(10, i-1);
            }else{
                total+=(high+1)*(int)Math.pow(10, i-1);
            }
            i++;
        }
        return total;
    }

    public static void main(String[] args) {

    }

}
