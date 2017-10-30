import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xiaojiez on 9/9/17.
 */
public class DynamicProxy {
    public static void main(String[] args) {
        HelloInterface helloInterface = (HelloInterface)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{
                HelloInterface.class
        }, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("hello world");
                return "bb";
            }
        });

        System.out.println(helloInterface.helloWord());
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        CountDownLatch countDownLatch;
        CyclicBarrier cyclicBarrier;

    }
}

interface HelloInterface{
    String helloWord();
}