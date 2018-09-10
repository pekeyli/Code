package book.jzoffer.ch6;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example45 {

    public int LastRemaining_Solution(int n,int m) {
        if(n==0) return -1;

        int s=0;
        for(int i=2;i<=n;i++){
            s=(s+m)%i;
        }
        return s;
    }

    public static void main(String[] args) {

    }
}
