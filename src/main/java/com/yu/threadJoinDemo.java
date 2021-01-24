package com.yu;

public class threadJoinDemo {

    public static void main(String[] args) {
        testThreadJoin();
    }

    public static void testThreadJoin(){

        System.out.println(Thread.currentThread().getName() + " start");
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        t.start();
        try{
            //调用线程等待t线程结束后继续进行
            //当前线程状态变化：running -> waiting -> running
            t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " end");
    }
}
