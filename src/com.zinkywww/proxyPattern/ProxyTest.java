package proxyPattern;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Hello hello = new Hello();
        InterfaceDemo proxy = (InterfaceDemo) Proxy.newProxyInstance(Hello.class.getClassLoader(),
                new Class<?>[]{InterfaceDemo.class},
                new ServiceInvocationHandler(hello));
        proxy.sayHello();

    }
}
