package javacode;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by yevgen on 28.02.17.
 */
public class ExampleOfReusing {
    public static void main(String[] args) {

        /** Prepare the stream of strings */
        String phrase = "The result depends upon the order in which the operations are performed";
        String[] array = phrase.split(" ");
        Stream<String> stream = Arrays.stream(array).filter(s -> s.startsWith("o"));

        /** Try to reuse the same stream */
//        stream.anyMatch(s -> true);    // operation completed successfully
//        stream.noneMatch(s -> true);   // throw Exception

        /** Each time using a new stream */
        Supplier<Stream<String>> streamSupplier = () -> Arrays.stream(array).filter(s -> s.startsWith("o"));
        streamSupplier.get().anyMatch(s -> true);   // operation completed successfully
        streamSupplier.get().noneMatch(s -> true);  // here is too
    }
}


