package javacode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by yevgen on 28.02.17.
 */
public class ExampleOfConsuming {
    public static void main(String[] args) {

        /** Prepare the stream of strings */
        Stream<String> stream = Arrays.stream(("The result depends upon the order " +
                "in which the operations are performed")
                .split(" "));

        /**  It won’t do anything. The stream just sits there, never having been consumed */
//        stream.filter(s -> {
//                    System.out.println("filter is an intermediate operation");
//                    return true;
//                });

        /** The stream will consume */
        stream.filter(s -> {
            System.out.println("filter: produces a new stream with " + s);
            return true;
        })
                .forEach(s -> System.out.println("forEach: just println " + s));
    }
}