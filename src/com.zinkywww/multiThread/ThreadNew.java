package multiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadNew extends Thread {
    private int flag;

    AtomicInteger atomicIndex;


    public ThreadNew(int flag, AtomicInteger atomicIndex) {
        this.flag = flag;
        this.atomicIndex = atomicIndex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (atomicIndex) {
                while (atomicIndex.get() % 3 != flag) {
                    try {
                        atomicIndex.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println((char) ('A' + flag));
                atomicIndex.incrementAndGet();
                atomicIndex.notifyAll();

            }
        }


    }
}
