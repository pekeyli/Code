package book.jzoffer.ch7;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example49 {

    public int StrToInt(String str)
    {
        if (str.equals("") || str.length() == 0)//空字符串情况
            return 0;
        char[] a = str.toCharArray();
        int i = 0;
        boolean fuhao = true;//+-符号位
        if (a[0] == '-'){
            fuhao = false;
            i = 1;//第一位如果是-号，则从第二位开始循环
        }
        int sum = 0;
        for (; i < a.length; i++)
        {
            if (a[i] == '+')
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;//有非数字字符
            sum = sum * 10 + a[i] - 48;

            //判断是否溢出，正整数最大0X7FFF FFFF,最小负整数0X8000 0000
            if((fuhao && sum > 0X7fffffff) || (!fuhao && sum < 0X80000000)){
                sum = 0;
                break;
            }

        }
        return fuhao ? sum : sum * -1;
    }
}
