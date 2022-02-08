package com.wenso.codesegment.concurrent.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yuwensong
 * @date 2022/2/2
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                    System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(200);
        latch.countDown();
    }
}
