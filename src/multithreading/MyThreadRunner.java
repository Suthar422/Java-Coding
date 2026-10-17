package multithreading;

import java.util.concurrent.Callable;

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is running");
    }


}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("Runnable is running");
        }
    }
}

class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return 4;
    }
}

public class MyThreadRunner {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("MyThread");


        t1.start();

//        Thread t2 = new Thread(new MyRunnable());
//        t2.setDaemon(true);
//        t2.start();

        MyRunnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);
        t2.start();

        //3rd way
        Thread t3 = new Thread(()->
        {
            System.out.println("Lambda is running");
        });
        t3.start();

//        try{
//            t1.join();
//            t2.join();
//            t3.join();
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }

        System.out.println("Main thread is running "+t1.currentThread().getName());


        //4th way
        Runnable r = ()-> System.out.println("Runnable is running");
        new Thread(r).start();
    }
}

