package concurrency;

public class FooBar {
    private final int n;
    private static volatile boolean flag;

    public FooBar(int n) {
        this.n = n;
        flag = true;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag)
                wait();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = !flag;
            notify();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag)
                wait();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = !flag;
            notify();
        }
    }
}
