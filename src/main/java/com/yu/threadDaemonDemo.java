package com.yu;

public class threadDaemonDemo {
    public static void main(String[] args) {
        //testJvmProcessEndTime();
        testDaemonThread();
    }

    //程序会一直执行下去，jvm不会退出
    public static void testJvmProcessEndTime(){
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "start");
            int n = 0;
            while (true){
                n++;
                System.out.println(n + " hello!");
            }
        });
        t.start();
    }

    //程序不会一直执行
    public static void testDaemonThread(){
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "start");
            int n = 0;
            while (true){
                n++;
                System.out.println(n + " hello!");
            }
        });
        t.setDaemon(true);//将该线程设置为守护线程
        t.start();
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
