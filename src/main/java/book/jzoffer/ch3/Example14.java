package book.jzoffer.ch3;

/**
 * Created by pekey on 2017/12/20.
 */
public class Example14 {

    public static void reOrderOddEven(int[] array){
        //快排的思想
        if(array == null || array.length<2)
            return ;
        int left = 0;
        int right = array.length-1;
        int temp =0;

        while(left <right){
            while(left<right && !func(array[left])){
                left ++;
            }
            while(left<right && func(array[right])){
                right --;
            }
            temp = array[right];
            array[right] = array[left];
            array[left] = temp;
        }
    }

    public static boolean func(int n){
        return (n & 0x1) == 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,3,5};
        reOrderOddEven(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
