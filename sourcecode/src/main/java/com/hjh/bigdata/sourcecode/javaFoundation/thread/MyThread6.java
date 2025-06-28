package com.hjh.bigdata.sourcecode.javaFoundation.thread;

public class MyThread6 extends Thread {

    public static void main(String[] args) {
        Thread thread = new MyThread6();
        thread.start();
        thread.interrupt();
    }

    /**
     * 先执行一段时间的线程,然后在睡眠时停止线程会进入catch语句，并且清除停止状态值，使之变为false。
     */
    public void run() {
        super.run();
        try {
            System.out.println("线程开始。。。");
            for (int i = 0; i < 10000; i++) {
                System.out.println("i=" + i);
            }
            Thread.sleep(200000);
            System.out.println("线程结束。");
        } catch (InterruptedException e) {
            System.out.println("先停止，再遇到sleep，进入catch异常");
            e.printStackTrace();
        }

    }
}
