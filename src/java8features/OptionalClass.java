package java8features;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        String[] str = new String[5];
        str[2] = "Geeks Classes are coming soon";

        Optional<String> empty = Optional.empty();
        System.out.println(empty);

        Optional<String> value = Optional.of(str[2]);
        System.out.println(value);

  System.out.println(Optional.of(str[1])); //gives null pointer exception
        System.out.println(Optional.ofNullable(str[1])); // gives Optional.empty()


    }
}
