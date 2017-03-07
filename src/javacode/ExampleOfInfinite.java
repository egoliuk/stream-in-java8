package javacode;

import java.util.stream.IntStream;

/**
 * Created by yevgen on 28.02.17.
 */
public class ExampleOfInfinite {
    public static void main(String[] args) {

        /** Will run indefinitely */
//        IntStream.iterate(0, i -> i + 1)
//                .forEach(s -> System.out.println(s));

        /** That's better */
        IntStream.iterate(0, i -> i + 1)
                .limit(10)
                .forEach(s -> System.out.println(s));

        /** Will run indefinitely */
//        IntStream.iterate(0, i -> ( i + 1 ) % 2)
//                .distinct()
//                .limit(10)
//                .forEach(s -> System.out.println(s));

        /** That's better */
        IntStream.iterate(0, i -> (i + 1) % 2)
                .limit(10)
                .distinct()
                .forEach(s -> System.out.println(s));

        /** Will run indefinitely. It will probably consume all CPU on your machine */
//        IntStream.iterate(0, i -> ( i + 1 ) % 2)
//                .parallel()
//                .distinct()
//                .limit(10)
//                .forEach(s -> System.out.println(s));
    }
}
