package book.jzoffer.ch6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example44 {

    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0 || numbers.length > 5){
            return false;
        }
        ArrayList<Integer> al = new ArrayList<>();
        int len = numbers.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            //必须去0，因为0可以是任意数字，如0，2，3，5，6，也是连续的
            if(0 == numbers[i]){
                count++;
            }else{
                al.add(numbers[i]);
            }
        }
        //非0的排序
        Collections.sort(al);
        int len1 = al.size();
        //大于4，肯定false
        if(Math.abs(al.get(0) - al.get(len1 - 1)) > 4){
            return false;
        }
        for(int i = 0; i < len1 - 1; i++){
            //相邻的只差，大于0不能重复，大于4肯定false
            int temp = al.get(i + 1) - al.get(i);
            if(0 < temp && temp < 5){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
