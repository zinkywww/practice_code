package deadLock;

import java.util.concurrent.locks.ReentrantLock;

public class deadLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();
        Thread t1 = new Thread(()->{
            while(true){
                lockA.lock();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lockB.lock();
                System.out.println("线程 1 还活着");
                lockB.unlock();
                lockA.unlock();
            }
        });
        Thread t2 = new Thread(()->{
            while(true){
                lockB.lock();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lockA.lock();
                System.out.println("线程 2 还活着");
                lockA.unlock();
                lockB.unlock();
            }
        });
        t1.start();
        t2.start();
    }
}
