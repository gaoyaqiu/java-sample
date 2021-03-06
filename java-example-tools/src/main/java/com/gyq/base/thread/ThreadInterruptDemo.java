package com.gyq.base.thread;

/**
 * @author gaoyaqiu
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        // Thread 实现 Runnable，如果没有传递 Runnable 对象实现， 则会空执行一次
        Thread thread = new Thread(ThreadInterruptDemo::sayHelloWorld);

        // thread.interrupt() 方法在 start() 调用之前是没有效果的
        thread.start(); // 启动线程

        thread.interrupt(); // main 线程 interrupt 子线程

        // interrupt() 并不能中止线程，但是可以传递 interrupt 状态
        thread.join(); // 等待线程结束

    }

    public static void sayHelloWorld() {
        Object monitor = ThreadInterruptDemo.class;
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                // 当前 interrupted 状态被清除 == false
                e.printStackTrace();
                System.out.printf("线程 [Id: %s] 当前 interrupted 状态 = %s\n",
                        Thread.currentThread().getId(), Thread.currentThread().isInterrupted());
                return;
            }
        }

        System.out.printf("线程 [Id : %s] : Hello,World!\n", Thread.currentThread().getId());
    }
}
