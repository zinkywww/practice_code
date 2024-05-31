package proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceInvocationHandler implements InvocationHandler {
    private Object target;
    public ServiceInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy: Doing Something before method" );
        Object result = method.invoke(target, args);
        System.out.println("Proxy: Doing Something after method" );
        return result;
    }
}
