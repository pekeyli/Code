package book.jzoffer.ch2;

import designPattern.Singleton;

/**
 * Created by pekey on 2017/11/29.
 */
public class Example2 {
}

class Singleton1 {
    //懒汉式

    private  Singleton1(){}

    private static Singleton1 instance = null;

    public static synchronized Singleton1 getInstance(){
        if(instance == null) {
            instance = new Singleton1();
        }
        return  instance;
    }
}

class Singleton2 {
    //饿汉式

    private Singleton2(){}

    private static Singleton2 instance = new Singleton2();

    private static Singleton2 getInstance(){
        return instance;
    }

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

class Singleton4{
    //静态内部类

    private Singleton4(){}

    private static class LazyHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static final Singleton4 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
