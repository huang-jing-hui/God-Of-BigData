package com.hjh.bigdata.sourcecode.javaFoundation.thread;

public class MyThread3 extends Thread {

    public static void main(String[] args) {
        Thread thread = new MyThread3();
        thread.start();
        try {
            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在线程中用for语句来判断一下线程是否是停止状态，如果是停止状态，则后面的代码不再运行即可：
     * 如果没有手动的停止运行,那么代码还是会继续执行
     */
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {
                System.out.println("线程已经终止， for循环不再执行");
                break;
            }
            System.out.println("i=" + (i + 1));
        }
        // 线程一旦执行了interrupt()方法，那么线程就会终止，但是线程终止之后，线程中的代码会继续执行，直到运行结束。
        System.out.println("这是for循环外面的语句，也会被执行");
    }
}
