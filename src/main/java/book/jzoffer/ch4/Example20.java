package book.jzoffer.ch4;

/**
 * Created by pekey on 2017/12/22.
 */
public class Example20 {
    public static void printMatrixClockWisely(int[][] numbers){
        if(numbers == null)
            return;
        int x = 0;//记录一圈（环）的开始位置的行
        int y = 0;//记录一圈（环）的开始位置的列
        //对每一圈（环）进行处理
        //行号最大是(numbers.length-1)/2
        //列号最大是(numbers[0].length-1)/2
        while(x*2<numbers.length&&y*2<numbers[0].length){
            printMatrixInCircle(numbers,x,y);
            x++;
            y++;
        }
    }

    private static void printMatrixInCircle(int[][] numbers, int x, int y) {
        int rows = numbers.length;
        int cols = numbers[0].length;

        //输出环的上面一行，包括最中的那个数字
        for(int i = y;i<=cols-y-1;i++)
            System.out.print(numbers[x][i]+" ");

        //环的高度至少为2才会输出右边的一列
        //rows-x-1:表示的是环最下的那一行的行号
        if(rows-x-1>x){
            for(int j =x+1;j<=rows-x-1;j++)
                System.out.print(numbers[j][cols-y-1]+" ");
        }

        //环的高度至少是 2并且环的宽度至少是2才会输出下面那一行
        //cols-1-y:表示的是环最右那一列的列号
        if(rows-x-1>x &&cols-1-y>y){
            for(int j =cols-1-y-1;j>=y;j--)
                System.out.print(numbers[rows-x-1][j]+" ");
        }

        //环的高度至少是 3并且环的宽度至少是2才会输出下面那一行
        if(rows-x-1-1>x&&cols-1-y>y)
            for(int j =rows-x-1-1;j>=x+1;j--)
                System.out.print(numbers[j][y]+" ");

    }

    public static void main(String[] args) {
        int[][] numbers ={
                {1,2,3,4,5},
                {16,17,18,19,6},
                {15,24,25,20,7},
                {14,23,22,21,8},
                {13,12,11,10,9}
        };
        int[][] numbers5 = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8}
        };
        printMatrixClockWisely(numbers5);
        System.out.println("");
        printMatrixClockWisely(numbers);

    }

}
