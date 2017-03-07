package javacode;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by yevgen on 27.02.17.
 */
public class ExampleOfSorted {
    public static void main(String[] args) {

        /** Prepare the array of strings */
        String phrase = "The result depends upon the order in which the operations are performed";
        String[] array = phrase.split(" ");

        /** Create a Supplier to return a new Stream each time the supplier is invoked */
        Supplier<Stream<String>> streamSupplier = () -> Arrays.stream(array);

        /** It demonstrates stateful intermediate sorted operation */
        streamSupplier.get()
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("o");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("\n" + "Changing order" + "\n");

        streamSupplier.get()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("o");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
