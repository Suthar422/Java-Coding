package inheritance;

interface X{
    default void show(){
        System.out.println("X");
    }
}

interface Y{
    default void show(){
        System.out.println("Y");
    }
}

public class MultipleInheritanceInterface implements X,Y{

    @Override
    public void show() {
       X.super.show();
       Y.super.show();
    }

    public static void main(String[] args) {
        MultipleInheritanceInterface obj = new MultipleInheritanceInterface();
        obj.show();
    }

}
