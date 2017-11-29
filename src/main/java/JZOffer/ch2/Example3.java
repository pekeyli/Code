package JZOffer.ch2;

/**
 * Created by pekey on 2017/11/14.
 */
public class Example3 {

    static boolean find(int[][] array,int col,int row,int target) {

        boolean tmp = false;
        if(array!=null){
            int r = 0;
            int c = col - 1;
            while (r<row && c>=0){
                if(array[r][c]==target){
                    tmp = true;
                    break;
                }else if(array[r][c]>target){
                    c--;
                }else{
                    r++;
                }
            }
        }

        return tmp;
    }

    public static void main(String[] args) {
        int array[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(array,4,4,10));
    }

}
