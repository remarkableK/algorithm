package com.zk.bytedance.spring;

import java.util.Scanner;

/**
 * Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。
 * 现在小Y使用1024元的纸币购买了一件价值为的商品，请问最少他会收到多少硬币？
 */
public class Coins {
    public int money;
    public int sum;
    private void soultion(int value){
        if (money > 0){
            sum = sum + money/ value;
            money = money % value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        Coins coins = new Coins();
        coins.money = 1024 -money;
        coins.soultion(64);
        coins.soultion(16);
        coins.soultion(4);
        coins.soultion(1);
        System.out.println(coins.sum);
    }
}
