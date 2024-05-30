package singletonPattern;

public class SingletonLazySync {
    //lazy初始化，使用synchronized同步，线程安全
    private static SingletonLazySync instance;
    private SingletonLazySync() {}
    public static synchronized SingletonLazySync getInstance() {
        if (instance == null) {
            instance = new SingletonLazySync();
        }
        return instance;
    }
}
