package com.hjh.bigdata.sourcecode.javaFoundation.thread;

public class MyThread2 extends Thread {
    /**
     * 判断线程是否停止状态 Thread.java类中提供了两种方法：
     * this.interrupted(): 测试当前线程是否已经中断；
     * this.isInterrupted(): 测试线程是否已经中断；
     * 那么这两个方法有什么图区别呢？
     * 我们先来看看this.interrupted()方法的解释：
     * 测试当前线程是否已经中断，当前线程是指运行this.interrupted()方法的线程。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("interruptedTest1:");
        interruptedTest1();

        System.out.println("interruptedTest2:");
        interruptedTest2();

        System.out.println("isInterruptedTest1:");
        isInterruptedTest1();
    }

    private static void interruptedTest1() {
        Thread thread = new MyThread2();
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();
            // 此时的当前线程是 main函数, 所以返回的都是false
            System.out.println("stop 1->" + thread.interrupted());
            System.out.println("stop 2->" + thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void interruptedTest2() {
        Thread.currentThread().interrupt();
        // 此时加入停止标记的是当前线程, 所以返回的第一个是true,而interrupted会在执行后清除标记所有第二个返回的是false
        System.out.println("stop 1->" + Thread.interrupted());
        System.out.println("stop 2->" + Thread.interrupted());
        System.out.println("End");
    }

    private static void isInterruptedTest1() {
        Thread thread = new MyThread2();
        thread.start();
        thread.interrupt();
        // isInterrupted测试的是thread的中断状态,但是不会在执行后清除中断状态,所以返回的都是true
        System.out.println("stop 1->" + thread.isInterrupted());
        System.out.println("stop 2->" + thread.isInterrupted());

    }

    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            i++;
        }
    }
}




