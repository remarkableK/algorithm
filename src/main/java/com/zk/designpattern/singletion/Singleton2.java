package com.zk.designpattern.singletion;

/**
 * 三种线程安全的单例模式
 * 第二，双锁检查
 */
public class Singleton2 {
    /**
     * volatile 修饰的私有静态 实例对象
     * volatile 保证了可见性 阻止了指令重排序
     */
    private static volatile Singleton2 instance = null;

    /**
     * 私有的构造器
     */
    private Singleton2(){
    }

    /**
     * 静态的获取实例的方法
     * @return
     */
    public static Singleton2 getInstance(){
        //第一次判断别忘记了
        if (instance == null){
            synchronized (Singleton2.class){
                if (instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
