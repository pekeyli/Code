package JZOffer.ch2;

/**
 * Created by pekey on 2017/12/19.
 */
public class Example9 {

    public static int Fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        int left =0,right =1,fib=0;
        if(n>1){
            for(int i=1;i<n;i++){
                fib = left+right;
                left =right;
                right = fib;
            }
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
    }

}
