package com.zk.designpattern.singletion;

/**
 * 三种线程安全的单例模式
 * 第一，静态内部类
 */
public class Singleton1 {
    /**
     * private的空构造器
     */
    private Singleton1(){}

    /**
     * 私有的静态的内部类，持有static final 的单例对象
     */
    private static class InnerClss{
        private static final Singleton1 SINGLETON_1 = new Singleton1();
    }

    /**
     * public static 的 get方法
     * @return
     */
    public static Singleton1 getInstance(){
        return InnerClss.SINGLETON_1;
    }

}
