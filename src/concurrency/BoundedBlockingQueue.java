package concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arnab.ray
 * @created on 04/11/22
 */
public class BoundedBlockingQueue {
    private final int capacity;
    private final List<Integer> queue;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>(capacity);
    }

    public void enqueue(int element) throws InterruptedException {
        while (this.size() == capacity)
            wait();
        queue.add(0, element);
        notifyAll();
    }

    public int dequeue() throws InterruptedException {
        while (queue.isEmpty())
            wait();
        int element = queue.get(this.size() - 1);
        notifyAll();
        return element;
    }

    public int size() {
        return queue.size();
    }
}
