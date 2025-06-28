package com.hjh.bigdata.sourcecode.javaFoundation.thread;

public class MyThread1 extends Thread {
    public static void main(String[] args) {
        Thread thread = new MyThread1();
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();// interrupt只会打上一个停止标记,而不会真的停止线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}




