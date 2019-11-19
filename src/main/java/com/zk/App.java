package com.zk;

/**
 * Hello world!
 */
public class App {
    private Object lock = new Object();

    public void lock() {
        synchronized (Object.class) {
            System.out.println("lock");
        }
        method();
    }

    private synchronized static void method() {
    }

    public static void main(String[] args) {
        System.out.println(4/3%100000007);
    }
}
