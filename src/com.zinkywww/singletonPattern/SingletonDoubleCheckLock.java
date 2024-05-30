package singletonPattern;

public class SingletonDoubleCheckLock {
    //使用双锁机制，安全且在多线程下保持高性能（相比于懒汉式加锁），volatile是为了禁用指令重排序，防止获取到未正确初始化的实例
    private volatile static SingletonDoubleCheckLock instance;
    private SingletonDoubleCheckLock() {}
    public static SingletonDoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheckLock.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheckLock();
                }
            }
        }
        return instance;
    }
}
