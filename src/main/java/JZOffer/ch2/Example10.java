package JZOffer.ch2;

/**
 * Created by pekey on 2017/12/19.
 */
public class Example10 {

    public static int NumberOf1InBinary(int n){
        int count = 0;
        while(n !=0){
            ++count;
            n=(n-1)&n;
        }
        return count;

    }

    public static void main(String[] args) {
        int n = -1;
        System.out.println(n+NumberOf1InBinary(n));

    }
}
