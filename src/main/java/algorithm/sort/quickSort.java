package algorithm.sort;

/**
 * Created by pekey on 2018/8/26.
 */
public class quickSort {
    //快速排序
    public static void quickSort1(int[] a, int s, int e){
        if (s >= e) return;

        int pivot = a[s];
        int left = s + 1;
        int right = e;

        while (left <= right) {
            while (left <= right && a[left] < pivot) {
                left++;
            }
            while (left <= right && a[right] >= pivot) {
                right--;
            }
            if (left <= right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }

        int temp = a[right];
        a[right] = a[s];
        a[s] = temp;

        quickSort1(a, s, right - 1);
        quickSort1(a, right + 1, e);
    }

    public static void quickSort2(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while(i < j && s[j] >= x)
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x)
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quickSort2(s, l, i - 1);
            quickSort2(s, i + 1, r);
        }
    }

    public static void main(String[] args) {

    }
}
