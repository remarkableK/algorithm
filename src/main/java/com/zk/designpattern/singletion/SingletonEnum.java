package com.zk.designpattern.singletion;

/**
 * 三种线程安全的单例模式
 * 第二，枚举类
 */
public enum SingletonEnum {
    /**
     * 单体实例
     */
    INSTANCE;
    /**
     * default的构造器 枚举
     */
    SingletonEnum(){
    }
}
