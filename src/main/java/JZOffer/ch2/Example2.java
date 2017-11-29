package JZOffer.ch2;

/**
 * Created by pekey on 2017/11/29.
 */
public class Example2 {
}

class Singleton1 {

    private  Singleton1(){}

    private static Singleton1 instance = null;

    public static Singleton1 getInstance(){
        if(instance == null) {
            instance = new Singleton1();
        }
        return  instance;
    }
}

class Singleton2 {

    private Singleton2(){}

}

class Singleton3 {
    //双重同步锁

    private Singleton3(){}

    private static volatile Singleton3 instance = null;

    public static Singleton3 getInstance(){
        if(instance == null){
            synchronized (Singleton3.class){
                if (instance == null){
                    instance = new Singleton3();
                }
            }
        }

        return instance;
    }
}
