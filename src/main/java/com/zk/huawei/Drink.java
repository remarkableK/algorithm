package com.zk.huawei;

import java.util.Scanner;

public class Drink {
    public void solution(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            if (num == 0){
                break;
            }
            if (num < 3){
                System.out.println(0);
            }
            int result = 0;
            int remain;
            while (num > 2){
                result = result + num / 3;
                remain = num%3 + num/3;
                num = remain;
            }
            if (num == 2){
                result = result+1;
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Drink drink = new Drink();
        drink.solution();
    }
}
