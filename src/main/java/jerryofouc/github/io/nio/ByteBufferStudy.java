package jerryofouc.github.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能介绍：
 *
 * @author zhangxiaojie
 *         Date:  8/17/14
 *         Time: 9:03
 */
public class ByteBufferStudy {
    public static void main(String args[]){
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(2);

        System.out.println(byteBuffer.get());;
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());

        CyclicBarrier cyclicBarrier;
        ReentrantLock reentrantLock;
        Semaphore semaphore;

    }
}
