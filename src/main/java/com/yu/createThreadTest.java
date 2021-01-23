package com.yu;

/**
 * 创建线程的方法
 * 1.通过继承thread方式创建线程
 * 2.实现Runnbale接口
 */
public class createThreadTest {
    public static void main(String[] args) {

        System.out.println("[" + Thread.currentThread().getName() + "]" + " this thread is main thread!");
        createThreadByExtendsThread();
        createThreadByImplementsRunnable();
        createThreadByLambda();
    }

    public static void createThreadByExtendsThread(){
        Thread t = new myThread();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        t.start();
    }

    public static void createThreadByImplementsRunnable(){
        Thread t = new Thread(new MyRunnable());
        t.start();
    }

    public static void createThreadByLambda(){
        Thread t = new Thread(() -> {
            System.out.println("[" + Thread.currentThread().getName() + "]" + " this thread created by lambda!");
        });
        t.start();
    }
}

class myThread extends Thread{

    @Override
    public void run(){
        System.out.println("[" + Thread.currentThread().getName() + "]" + " this thread created by extends Thread!");
    }
}

class MyRunnable implements Runnable {

    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "]" + " this thread created by implements Runnable!");
    }
}

