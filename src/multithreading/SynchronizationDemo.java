package multithreading;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter{
    public final Lock lock = new ReentrantLock(true);
    int cnt=0;
     void increment() throws InterruptedException {
         if (lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
             try {
                cnt++;
             } finally {
                 lock.unlock();
             }
         } else {
             // perform alternative actions
         }

    }
    int getCount(){
        return cnt;
    }
}

class CounterThread extends Thread{
    Counter c;

    public CounterThread(Counter c){
        this.c = c;
    }
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            try {
                c.increment();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class SynchronizationDemo {
    public static void main(String[] args) {
        Counter c = new Counter();
        CounterThread t1 = new CounterThread(c);
        CounterThread t2 = new CounterThread(c);

        t1.start();
        System.out.println("Thread 1 started");
        t2.start();
        System.out.println("Thread 2 started");
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(t1.c.getCount());
    }
}


