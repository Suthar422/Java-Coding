package multithreading;

import java.util.Arrays;

public class OddEvenFromArray {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1, 2, 3, 4, 5};

        Thread even = new Thread( () -> {
            Thread.currentThread().setName("Even");
            System.out.println(Thread.currentThread().getName());
            Arrays.stream(arr).filter(i -> i % 2 == 0).forEach(System.out::println);
        });

        Thread odd = new Thread( () -> {
            Thread.currentThread().setName("Odd");
            System.out.println(Thread.currentThread().getName());
            Arrays.stream(arr).filter(i -> i % 2 != 0).forEach(System.out::println);
        });

        even.start();
        Thread.sleep(1000);
        odd.start();

        try {
            even.join();
            odd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
