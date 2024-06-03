package multiThread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
* chatGPT写的错误的方法！！！浪费我两小时
*
* */


public class loopPrintABC {
    public static void main(String[] args) throws InterruptedException {
        int[] flag = {0};
        ReentrantLock lock = new ReentrantLock();
        Condition[] condition = new Condition[3];
        for (int i = 0; i < 3; i++) {
            condition[i] = lock.newCondition();
        }
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                6,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        MyThread myThread1 = new MyThread(0, lock, condition);
        MyThread myThread2 = new MyThread(1, lock, condition);
        MyThread myThread3 = new MyThread(2, lock, condition);
        pool.execute(myThread1);
        pool.execute(myThread2);
        pool.execute(myThread3);
        Thread.sleep(1000L);
        lock.lock();
        condition[0].signalAll();
        lock.unlock();
        pool.shutdown();


    }
}
