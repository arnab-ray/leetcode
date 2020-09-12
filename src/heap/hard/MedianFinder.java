package heap.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    double effectiveMedian = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (minHeap.size() < maxHeap.size()) {
            if (num < effectiveMedian) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        } else if (minHeap.size() > maxHeap.size()) {
            if (num > effectiveMedian) {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else {
            if (num < effectiveMedian)
                maxHeap.add(num);
            else
                minHeap.add(num);
        }

        if(minHeap.size() == maxHeap.size()) {
            effectiveMedian = (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            effectiveMedian = minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }

    public double findMedian() {
        return effectiveMedian;
    }
}
