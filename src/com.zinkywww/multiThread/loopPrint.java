package multiThread;

import java.nio.file.AtomicMoveNotSupportedException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class loopPrint {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                6,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ThreadNew t0 = new ThreadNew(0, atomicInteger);
        ThreadNew t1 = new ThreadNew(1, atomicInteger);
        ThreadNew t2 = new ThreadNew(2, atomicInteger);
        pool.execute(t0);
        pool.execute(t1);
        pool.execute(t2);
        pool.shutdown();


    }
}
