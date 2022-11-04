package concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author arnab.ray
 * @created on 04/11/22
 */
public class ZeroEvenOdd {
    private final int n;
    private final Semaphore semaphoreZero = new Semaphore(1);
    private final Semaphore semaphoreOdd = new Semaphore(0);
    private final Semaphore semaphoreEven = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean isOdd = true;
        for (int i = 0; i < n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            if (isOdd) {
                semaphoreOdd.release();
            } else {
                semaphoreEven.release();
            }

            isOdd ^= true;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            semaphoreOdd.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }
}
