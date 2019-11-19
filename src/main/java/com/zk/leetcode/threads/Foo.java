package com.zk.leetcode.threads;

import java.util.concurrent.CountDownLatch;

public class Foo {
    private CountDownLatch a;
    private CountDownLatch b;

    public Foo() {
        a = new CountDownLatch(1);
        b = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        a.countDown();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        a.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        b.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        b.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}