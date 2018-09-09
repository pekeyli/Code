package algorithm.search;

/**
 * Created by pekey on 2018/8/26.
 */
public class binarySearch {

    public static int binarySearch(int[] a, int n){
        int left = 0;
        int right = a.length-1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] == n) {
                return mid;
            } else if (a[mid] > n) {
                right = mid - 1;
            } else {
                left = left + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int n = 4;
        System.out.println(binarySearch(a,n));
    }
}
