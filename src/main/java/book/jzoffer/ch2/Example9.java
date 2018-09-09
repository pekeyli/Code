package book.jzoffer.ch2;

/**
 * Created by pekey on 2017/12/19.
 */
public class Example9 {

    public static int Fibonacci1(int n) {
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int pre = 1;
        int prepre = 0;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = pre + prepre;
            prepre = pre;
            pre = res;
        }
        return res;
    }

    public int Fibonacci2(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return Fibonacci2(n-1) + Fibonacci2(n-2);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci1(3));
    }

}
