package jerryofouc.github.io;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 功能介绍：
 *
 * @author zhangxiaojie
 *         Date:  8/13/14
 *         Time: 23:35
 */
public class FutureExample {
    public static void main(String args[]){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println("t1");
            }
        }                             ;

        Callable<Integer> task2 = new Callable() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                System.out.println("t2");
                return 3;
            }
        };

       Future<?> f1 =  executorService.submit(task1);
        Future<Integer> f2 = executorService.submit(task2);
        while(!f1.isDone() || !f2.isDone()){

        }
        System.out.println("ddd");
    }
}
