package book.jzoffer.ch6;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example46 {

    public int Sum_Solution(int n) {
        int result = 0;
        int a = 1;
        boolean value = ((n!=0) && a == (result = Sum_Solution(n-1)));
        result += n;
        return result;
    }
}
