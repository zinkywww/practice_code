package multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/*
 * chatGPT写的错误的方法！！！浪费我两小时
 * 主要错误在于，假如线程一，线程二在释放锁之后，还未抢到锁，还没有睡眠，如果此时线程三
 * 抢到锁并唤醒线程一，然后线程三继续抢到锁睡眠，那么此时线程一睡眠后，就没有人唤醒，就会导致全部睡眠而没有人唤醒
 *
 * */
public class MyThread extends Thread {
    private int index;
    ReentrantLock lock;
    Condition[] condition;

    public MyThread() {}
    public MyThread(int index, ReentrantLock lock, Condition[] condition) {
        this.index = index;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread());
                condition[index].await();

                System.out.println((char)('A'+index)+String.valueOf(i));
                condition[(index+1)%3].signal();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }



    }
}
