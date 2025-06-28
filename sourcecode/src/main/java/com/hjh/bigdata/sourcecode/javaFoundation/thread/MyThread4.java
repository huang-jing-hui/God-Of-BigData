package com.hjh.bigdata.sourcecode.javaFoundation.thread;

public class MyThread4 extends Thread {

    public static void main(String[] args) {
        Thread thread = new MyThread4();
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
     * 这里的不在运行并不是自动实现的,而是需要抛出异常或者return
     */
    public void run() {
        try {
            super.run();
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println("线程已经终止， for循环不再执行");
                    //return;
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            // 线程一旦执行了interrupt()方法，那么线程就会终止，但是线程终止之后，线程中的代码会继续执行，直到运行结束。
            // 但是在判断线程终止状态之后抛出异常或者return，那么线程就会终止。
            System.out.println("这是for循环外面的语句，也会被执行");
        } catch (InterruptedException e) {
            System.out.println("MyThread4.java类中的catch了。。。");
            e.printStackTrace();
        }
    }
}
