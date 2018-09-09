package designPattern;

/**
 * Created by pekey on 2018/8/26.
 */
public class Singleton {
    //双重检查
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

//    //饿汉式 静态常量
//    private final static Singleton instance = new Singleton();
//
//    private Singleton() {
//    }
//
//    public static Singleton getIns() {
//        return instance;
//    }
//
//
//    //饿汉式 静态代码块
//    private static Singleton instance;
//
//    static {
//        instance = new Singleton();
//    }
//
//    private Singleton() {
//    }
//
//    public Singleton getInstance() {
//        return instance;
//    }
//
//    //懒汉式 线程不安全
//    private static Singleton instance;
//
//    private Singleton() {
//    }
//
//    public static Singleton getIns() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//
//    //懒汉式 线程安全，同步方法 [不推荐用]
//    private static Singleton instance;
//
//    private Singleton() {
//    }
//
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//
//    // 静态内部类 [推荐用]
//    private Singleton() {
//    }
//
//    private static class SingletonInstance {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return SingletonInstance.INSTANCE;
//    }

}
