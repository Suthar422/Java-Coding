package string;

import java.util.Objects;

public class EqualsDemo {
    public int id;
    public String name;

    public EqualsDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((EqualsDemo)obj).id && this.name.equals(((EqualsDemo)obj).name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(this.id, this.name);
//    }

    public static void main(String[] args) {
        EqualsDemo obj1 = new EqualsDemo(1, "Geeks");
        EqualsDemo obj2 = new EqualsDemo(1, "Geeks");
        System.out.println(obj1.equals(obj2));
        ////false bcz not overriding equals() method
        //"Without overriding hashCode(), two logically equal objects may end up in different hash buckets, breaking the contract of collections like HashSet or HashMap."
        //If you override equals(), you must also override hashCode() to ensure consistency in collections like HashMap, HashSet.
        //== → compares references (memory addresses).
        //
        //equals() → compares logical equality (content).

    }
}
