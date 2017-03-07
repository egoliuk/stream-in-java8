package javacode;

import java.util.stream.IntStream;

/**
 * Created by yevgen on 27.02.17.
 */
public class ExampleСompareToScala {
    public static void main(String[] args) {
        IntStream.range(0, 10)
                .mapToObj(n -> concat("*", n))
                .forEach(s -> System.out.println(s));
    }

    /**
     * @param value
     * @param amount
     * @return
     */
    private static String concat(String value, int amount) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            str.append(value);
        }
        return str.toString();
    }
}
