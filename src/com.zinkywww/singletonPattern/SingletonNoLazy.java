package singletonPattern;

public class SingletonNoLazy {
    //非lazy初始化，线程安全，但在类加载时就进行初始化
    private static SingletonNoLazy instance=new SingletonNoLazy();
    private SingletonNoLazy(){}
    public static SingletonNoLazy getInstance(){
        return instance;
    }

}
