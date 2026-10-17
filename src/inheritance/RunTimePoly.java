package inheritance;


class Parent{
    public void run(){
        System.out.println("Hello");
    }
}
class Child extends Parent{

//    public void run(){
//        System.out.println("Hello World");
//    }
}


public class RunTimePoly {

    public static void main(String[] args) {
        Child c = new Child();
        c.run();
    }
}
