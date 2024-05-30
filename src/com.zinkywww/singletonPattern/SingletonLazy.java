package singletonPattern;

public class SingletonLazy {
    //非lazy初始化，线程不安全
    private static SingletonLazy instance;
    private SingletonLazy() {}
    public static  SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
