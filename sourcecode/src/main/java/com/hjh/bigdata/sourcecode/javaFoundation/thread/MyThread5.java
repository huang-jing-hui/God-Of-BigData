package com.hjh.bigdata.sourcecode.javaFoundation.thread;

public class MyThread5 extends Thread {

    public static void main(String[] args) {
        Thread thread = new MyThread5();
        thread.start();

        try {

            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在睡眠时停止线程会进入catch语句，并且清除停止状态值，使之变为false。
     */
    public void run() {
        super.run();

        try {
            System.out.println("线程开始。。。");
            Thread.sleep(200000);
            System.out.println("线程结束。");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止, 进入catch， 调用isInterrupted()方法的结果是：" + this.isInterrupted());
            e.printStackTrace();
        }

    }
}
