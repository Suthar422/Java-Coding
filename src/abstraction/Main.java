package abstraction;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Abstract class cannot be instantiated directly
abstract class Animal {
    // Abstract method: Has no body, must be implemented by subclass
    public abstract void makeNoise();

    public abstract void doSomething();

    // Concrete method: Has a body and shared logic
    public void sleep() {
        System.out.println("This animal is sleeping: Zzz...");
    }
}

// Concrete subclass
class Dog extends Animal {
    // Implementing the required abstract method
    public void makeNoise() {
        System.out.println("Bark Bark!");
    }


    public void doSomething() {
        System.out.println("Dog is doing something");
    }
}

public class Main {
    public static void main(String[] args) {
         Animal a = new Animal() {
             @Override
             public void makeNoise() {
                 System.out.println("Make noise");
             }

             @Override
             public void doSomething() {
                 System.out.println("Do something");
             }
         }; // ERROR! Cannot instantiate abstract class


        a.makeNoise();
        a.sleep();

        System.out.println("=====================");
        // Creating an object of the concrete subclass
        Dog myDog = new Dog();

        myDog.makeNoise(); // Calls the subclass implementation
        myDog.sleep();     // Calls the inherited concrete method from Animal

    }
}
