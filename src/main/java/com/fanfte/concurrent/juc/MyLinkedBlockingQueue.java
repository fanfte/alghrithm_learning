package com.fanfte.concurrent.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tianen on 2018/10/25
 *
 * @author fanfte
 * @date 2018/10/25
 **/
public class MyLinkedBlockingQueue<E> {

    private AtomicInteger count = new AtomicInteger();

    private int capacity;

    private final ReentrantLock putLock = new ReentrantLock();

    private final Condition notFull = putLock.newCondition();

    private final ReentrantLock takeLock = new ReentrantLock();

    private final Condition notEmpty = takeLock.newCondition();

    private Node<E> head ;

    private Node<E> tail;

    public MyLinkedBlockingQueue(int capacity) {
        if(capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        head = tail = new Node<>(null);
    }

    public MyLinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    static class Node<E> {
        private E item;

        private Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    public void put(E e) throws InterruptedException {
        if(e == null) throw new IllegalArgumentException();
        Node<E> node = new Node<E>(e);
        int c = -1;
        final ReentrantLock putLock = this.putLock;
        final Condition notFull = this.notFull;
        AtomicInteger count = this.count;
        try {
            putLock.lockInterruptibly();
            while(count.get() == capacity) {
                notFull.await();
            }
            enqueue(node);
            c = count.getAndIncrement();
            if(c + 1 < capacity) {
                notFull.signal();
            }
        } finally {
            putLock.unlock();
        }
        if(c == 0) {
            signalNotEmpty();
        }
    }

    public E take() throws InterruptedException {
        E e;
        int c = -1;
        ReentrantLock takeLock = this.takeLock;
        AtomicInteger count = this.count;
        takeLock.lockInterruptibly();
        try{
            while(count.get() == 0) {
                notEmpty.wait();
            }
            e = dequeue();
            c = count.getAndDecrement();
            if(c > 1) {
                // 如果获取的时候有2个及以上元素，则本次获取完成减少一个元素后，至少还有一个元素
                // 唤醒等待在notEmpty的其他线程来获取元素
                notEmpty.signal();
            }
        } finally {
            takeLock.unlock();
        }
        if(c == capacity) {
            // 在获取c之前如果元素已经满了，则出队列以后，可以往队列中添加元素
            // 唤醒等待在notFull上的线程来添加数据
            signalNotFull();
        }
        return e;
    }

    private void signalNotFull() {
        ReentrantLock putLock = this.putLock;
        takeLock.lock();
        try {
            notFull.signal();
        } finally {
            takeLock.unlock();
        }
    }

    private E dequeue() {
        // 头节点是一个item为null的冗余节点
        Node<E> h = this.head;
        Node<E> first = h.next;
        h.next = head;
        head = first;
        E e = first.item;
        first.item = null;
        return e;
    }

    private void signalNotEmpty() {
        ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }

    private void enqueue(Node<E> node) {
        tail = tail.next = node;
    }


    public static void main(String[] args) {
        MyLinkedBlockingQueue myLinkedBlockingQueue = new MyLinkedBlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            int num = i;
            new Thread(() -> {
                int j = 0;
                while(true) {
                    try {
                        myLinkedBlockingQueue.put("线程" + num + "元素" + j);
                        Thread.sleep(1000);
                        j ++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费-> " + myLinkedBlockingQueue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
