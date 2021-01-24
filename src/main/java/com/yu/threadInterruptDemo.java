package com.yu;

public class threadInterruptDemo {
    public static void main(String[] args) {
        testThreadInterrupt();
    }

    public static void testThreadInterrupt(){
        System.out.println("start");
        Thread t = new Thread(() -> {
            int n = 0;

            //1. 被中断后跳出循环
/*            while (!Thread.currentThread().isInterrupted()){
                n++;
                System.out.println(n + " hello!");
            }*/

            //2. 线程处于waiting状态，对于interrupt请求会抛出java.lang.InterruptedException，因此可以在异常捕获处进行处理
            while(true){
                try {
                    n++;
                    System.out.println(n + " hello!");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break; //sleep状态被interrupt后，break出while循环
                }
            }
        });
        t.start();
        try{
            Thread.sleep(10);
            t.interrupt(); //发起t线程中断
            t.join();      //等待t线程结束
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("end");
    }


}

