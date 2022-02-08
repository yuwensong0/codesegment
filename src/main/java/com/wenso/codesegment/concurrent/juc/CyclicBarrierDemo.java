package com.wenso.codesegment.concurrent.juc;

import javax.sound.midi.Soundbank;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author yuwensong
 * @date 2022/2/2
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("结束"));
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(200);
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
                    Thread.sleep(200);
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
//        System.in.read();

    }
}
