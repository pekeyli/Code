package book.jzoffer.ch5;

/**
 * Created by pekey on 2017/12/25.
 */
public class Example29 {

    public static int MoreThanHalfNum_Solution(int [] array) {
        //O(n)的思想是，定义两个变量result 和count，每次循环时，如果array[i]的值等于result ，则count自增，
        // 如不等并且count>0，则count自减，count==0，重新对temp赋值为当前array[i]，count赋值为1。
        if(array==null || array.length <= 0){
            return 0;
        }

        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == result) {
                count++;
            } else if (count > 0 ) {
                count--;
            } else if(count == 0){
                result = array[i];
                count = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3,5};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
