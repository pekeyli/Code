package book.jzoffer.ch6;

/**
 * Created by pekey on 2018/1/3.
 *
 *
 *
 */
public class Example40 {

    public static void FindNumsAppearOnce(int[] arr)
    {
        int len = arr.length;
        if(len<2)
            return;

        int i;
        int AllXOR = 0;
        //全部异或
        for(i=0;i<len;i++)
            AllXOR ^= arr[i];

        //找出第几位为1，如010
        int res = FindFirstBit1(AllXOR);

        int num1=0, num2 = 0;
        for(i=0;i<len;i++)
        {  //分成了两组
            if(IsBit1(arr[i],res))
                num1 ^= arr[i];
            else
                num2 ^= arr[i];
        }
        System.out.println(num1+"and"+num2);
    }

    /*
    返回num的最低位的1，其他各位都为0
    */
    public static int FindFirstBit1(int num)
    {
        //二者与后得到的数，将num最右边的1保留下来，其他位的全部置为了0
        return num & (-num);
    }

    /*
    判断data中特定的位是否为1，
    这里的要判断的特定的位由res确定，
    res中只有一位为1，其他位均为0，由FindFirstBit1函数返回，
    而data中要判断的位便是res中这唯一的1所在的位
    */
    public static boolean IsBit1(int data,int res)
    {
        return ((data & res)==0) ? false:true;
    }

    public static void main(String[] args) {
        int[] a = { 1,1,2,2,3,44,55,55,66,66,34,34,5,5,7,7 };
        FindNumsAppearOnce(a);
    }
}
