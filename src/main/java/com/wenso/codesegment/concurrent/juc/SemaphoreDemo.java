package com.wenso.codesegment.concurrent.juc;

import java.util.concurrent.Semaphore;

/**
 * @author yuwensong
 * @date 2022/2/2
 */
public class SemaphoreDemo {
    public static void main(String[] args) throws Exception {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        Semaphore semaphore3 = new Semaphore(1);
        semaphore2.acquire();
        semaphore3.acquire();
        new Thread(() -> {
            while (true) {
                try {
                    semaphore1.acquire();
                    System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
                    semaphore2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    semaphore2.acquire();
                    System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
                    semaphore3.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    semaphore3.acquire();
                    System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
                    semaphore1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
