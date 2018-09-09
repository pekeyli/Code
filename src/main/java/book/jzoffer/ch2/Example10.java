package book.jzoffer.ch2;

/**
 * Created by pekey on 2017/12/19.
 */
public class Example10 {
    public static int NumberOf1_low_low(int n){
        int count= 0;
        int flag = 1;
        while (n!= 0){
            if ((n & 1) != 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int NumberOf1_low(int n){
        int count= 0;
        int flag = 1;
        while (flag != 0){
            if ((n & flag) != 0){
                count++;
            }
            flag  = flag << 1;
        }
        return count;
    }

    public static int NumberOf1(int n){
        //一个整数和它减一得数做 位与 运算，相当于把最后的1变成0
        int count = 0;
        while(n !=0){
            ++count;
            n=(n-1)&n;
        }
        return count;

    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(NumberOf1(n));

    }
}
