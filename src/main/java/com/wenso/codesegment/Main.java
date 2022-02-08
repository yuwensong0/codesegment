package com.wenso.codesegment;

/**
 * @author yuwensong
 * @date 2022/2/6
 */
public class Main {
    public static void main(String[] args) {
        boolean[] isPrime = new boolean[101];
        int count = 0;
        for (int i = 2; i < 101; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i*i; j < 101; j+=i) {
                    isPrime[j] = true;
                }
            }
        }
        System.out.println(count);
    }
}
