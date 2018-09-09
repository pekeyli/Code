package LeetCode;

/**
 * Created by pekey on 2018/7/29.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int tmp = 1;
        int[] res = new int[digits.length];
        for(int i = digits.length-1;i>=0;i--){
            if(i == 0){
                if(digits[0] == 9 && tmp == 1){
                    res[0] = 0;
                    int[] new_res = new int[digits.length+1];
                    for(int j=new_res.length-1 ; j>=1;j--){
                        new_res[j] = res[j-1];
                    }
                    new_res[0] = 1;
                    res = new_res;
                    break;
                }
            }
            if(tmp == 1){
                if(digits[i] == 9){
                    tmp = 1;
                    res[i] = 0;
                }else{
                    tmp = 0;
                    res[i] = digits[i]+1;
                }
            }else {
                res[i] = digits[i];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] digit = {9,9,9,9};
        int[] res = plusOne(digit);
        for (int str : res) {
            System.out.println(str);
        }


    }
}
