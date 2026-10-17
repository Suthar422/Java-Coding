package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class MergeTwoList {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(6,7,8,9,10);

        //1st way to concat
        System.out.println(Stream.concat(list1.stream(), list2.stream()).toList());

        //2nd way
        System.out.println(Stream.of(list1, list2).toList());

        System.out.println(Stream.of(list1, list2).flatMap(Collection::stream).toList());

        System.out.println(Stream.concat(list1.stream(), list2.stream()).distinct().toList());


    }
}
