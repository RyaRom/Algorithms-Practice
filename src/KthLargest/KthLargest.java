package kthLargest;

import java.util.*;

class KthLargest {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(4, new int[]{4,5,8,2});
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(1);
        kthLargest.add(8);
    }
    private PriorityQueue<Integer> container = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        container = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (container.size() < k)
            container.offer(n);
        else if (container.peek() < n) {
            container.poll();
            container.offer(n);
        }
        return container.peek();
    }
}
