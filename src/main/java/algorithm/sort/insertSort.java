package algorithm.sort;

/**
 * Created by pekey on 2017/12/5.
 */
public class insertSort {

    //插入排序
    public static void insertSort(int[] a){
        int tmp = 0, j = 0;
        for (int i = 0; i < a.length; i++) {
            tmp = a[i];
            j = i-1;
            while(j>=0 && tmp < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 2, 7, 19, 100, 97, 63, 208, 55, 78};
        insertSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }


}
