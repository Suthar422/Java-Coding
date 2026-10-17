package interfacedemo;

@FunctionalInterface
public interface functionality {
    void doSomething();

    default void runner(){
        System.out.println("default method");
    }
}

class Test implements functionality{
    @Override
    public void doSomething() {
        System.out.println("Hello");
    }

    @Override
    public void runner(){
        System.out.println("default method for Test");
    }
}

class Test2 implements functionality{
    @Override
    public void doSomething() {
        System.out.println("Test2");
    }

    @Override
    public void runner(){
        System.out.println("default method for Test2");
    }
}

class Main {
    public static void main(String[] args) {
//      functionality f = () ->
//              System.out.println("Hello");
//
//
//      f.doSomething();


        Test2 t2 = new Test2();
        t2.runner();

    }
}
