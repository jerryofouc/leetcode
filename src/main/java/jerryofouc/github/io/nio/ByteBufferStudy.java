package jerryofouc.github.io.nio;

import java.util.concurrent.*;

/**
 * 功能介绍：
 *
 * @author zhangxiaojie
 *         Date:  8/17/14
 *         Time: 9:03
 */
public class ByteBufferStudy {
    public static void main(String args[]) throws ExecutionException, InterruptedException, ClassNotFoundException {


        ExecutorService executor = Executors.newCachedThreadPool();
        Future future = executor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(10000);
                return "aaa";
            }
        });

        System.out.println(future.get());;

        Thread thread = new Thread(new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "";
            }
        }

        ));
        Semaphore semaphore;

        ExecutorService executorService = Executors.newCachedThreadPool();

        Class a = Class.forName("");

        ExecutorService.class.getClassLoader();

        ClassLoader classLoader;

        return;
    }

}
