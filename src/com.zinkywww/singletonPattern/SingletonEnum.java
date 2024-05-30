package singletonPattern;

import java.util.HashMap;

public enum SingletonEnum {
    //使用枚举类，简单，线程安全，非lazy初始化，支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化
    INSTANCE;
    public void doSomething() {}

}
