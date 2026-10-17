


class A

{

    void m1() throws Exception

    {

        System.out.println("In m1 A");

    }

}

class B extends A

{

    void m1() throws  ArrayIndexOutOfBoundsException

    {

        System.out.println("In m1 B");

    }

}

public class Test {



    public static void main(String[] args) throws Exception {

        A a=new B();

        a.m1();

    }

}