package sort;

/**
 * Created by pekey on 2017/12/5.
 */
public class Sort {

    static int[] a = {9, 2, 7, 19, 100, 97, 63, 208, 55, 78};

    public static void print(){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }

    //插入排序
    public static void insertSort(){
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

    //快速排序
    public static void quickSort(){

    }

    //归并排序
    public static void Sort(){

    }

    public static void main(String[] args) {

        insertSort();
        print();
    }


}
