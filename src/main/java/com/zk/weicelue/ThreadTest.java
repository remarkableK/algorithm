package com.zk.weicelue;

public class ThreadTest implements Runnable{
    private Thread t;
    private String threadName;

    public ThreadTest( String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(threadName);
        }
    }
    public void start(){
        if (t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }

    public static void main(String[] args) {
        ThreadTest a =  new ThreadTest("A");
        ThreadTest b =  new ThreadTest("B");
        a.start();
        b.start();
    }
}

