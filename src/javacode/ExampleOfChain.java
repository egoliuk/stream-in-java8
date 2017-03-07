package javacode;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by yevgen on 27.02.17.
 */
public class ExampleOfChain {
    public static void main(String[] args) {

        /** Prepare the array of strings */
        String phrase = "The result depends upon the order in which the operations are performed";
        String[] array = phrase.split(" ");

        /** Create a Supplier to return a new Stream each time the supplier is invoked */
        Supplier<Stream<String>> streamSupplier = () -> Arrays.stream(array);

        /** It demonstrates order in which the operations are performed */
        streamSupplier.get()
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("R");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("\n" + "Changing order" + "\n");

        streamSupplier.get()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("r");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

    }
}
