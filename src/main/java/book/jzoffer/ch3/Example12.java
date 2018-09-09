package book.jzoffer.ch3;

/**
 * Created by pekey on 2017/12/20.
 */
public class Example12 {

    public static void print(int n) {
        char[] result = new char[n];
        printHelpRecursive(result, n, 0);

    }

    private static void printHelpRecursive(char[] result, int length, int index) {
        if (length == index) {
            printNumber(result);
        } else {
            for (int i = 0; i <= 9; i++) {
                result[index] = (char) ('0' + i);
                printHelpRecursive(result, length, index + 1);
            }
        }
    }

    private static void printNumber(char[] result) {
        int len = result.length;
        boolean canPrint = false;

        for (int i = 0; i < len - 1; i++) {
            if (!canPrint && result[i] != '0') {
                canPrint = true;
            }
            if (canPrint) {
                System.out.print(result[i]);
            }
        }

        System.out.println(result[len - 1]);
    }


    public static void main(String[] args) {
        print(3);
    }
}
