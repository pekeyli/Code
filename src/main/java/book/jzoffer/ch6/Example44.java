package book.jzoffer.ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example44 {

    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0)
            return false;
        Arrays.sort(numbers);
        int num1 = 0;
        int num2 = 0;
        // 统计0的个数
        while(num1 != numbers.length && numbers[num1] == 0)
            ++num1;
        // 计算除了0其他数字的空缺数
        for(int i = num1 + 1; i < numbers.length; ++i) {
            if(numbers[i] == numbers[i - 1])
                return false;
            num2 += numbers[i] - numbers[i - 1] - 1;
        }
        if(num1 >= num2)
            return true;
        return false;
    }

    public static void main(String[] args) {

    }
}
