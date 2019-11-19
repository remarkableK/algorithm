package com.zk.leetcode.threads;

public class Foo2 {

    private final Object obj = new Object();
    private boolean firstFinish = false;
    private boolean secondFinish = false;

    public Foo2() {

    }


    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (obj) {
            printFirst.run();
            firstFinish = true;
            obj.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (obj) {
            while (!firstFinish) {
                obj.wait();
            }
            printSecond.run();
            secondFinish = true;
            obj.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (obj) {
            while (!secondFinish) {
                obj.wait();
            }
            printThird.run();
        }
    }
}
