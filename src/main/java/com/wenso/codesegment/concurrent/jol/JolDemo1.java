package com.wenso.codesegment.concurrent.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author yuwensong
 * @date 2022/2/2
 */
public class JolDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        // 001 无锁
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            // 00 轻量级锁
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        Thread.sleep(5000);
        Object o2 = new Object();
        // 101 偏向锁
        System.out.println(ClassLayout.parseInstance(o2).toPrintable());
    }
}
