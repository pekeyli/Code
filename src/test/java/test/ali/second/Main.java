package test.ali.second;

/**
 * Created by pekey on 2018/8/3.
 */

public class Main {

    public static void main(String[] args) {
        S s = new S();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        s.pop();
//        s.pop();
//        s.pop();
//        s.pop();
//        s.push(1);
//        s.pop();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.pop();
        s.pop();

    }
}

class S{
    int capacity = 4;
    int[] a = new int[capacity];
    int num = 0;
    int flag = 0;

    public void push(int n){
        if(num == capacity){
            System.out.println("-" + a[flag]);
            a[flag] = n;
            System.out.println("+" + n);
            flag++;
        }else{
            a[flag] = n;
            System.out.println("+" + n);
            flag ++;
            if(flag == capacity){
                flag = 0;
            }
            num++;
        }
    }

    public int pop(){
        if(num == 0){
            return -1;
        }
        int result = -1;
        if(flag != 0){
            result = a[flag-1];
            a[flag-1] = -1;
        }else{
            flag = capacity;
            result = a[flag-1];
            a[flag-1] = -1;
        }

        flag--;
        num--;
        System.out.println("-" + result);
        return result;
    }

}