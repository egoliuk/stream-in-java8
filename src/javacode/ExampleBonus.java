package javacode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yevgen on 27.02.17.
 */
public class ExampleBonus {


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Richard", "Dawkins", "1941-03-26"));
        persons.add(new Person("Richard", "Feynman", "1918-05-11"));
        persons.add(new Person("Douglas", "Hofstadter", "1945-02-15"));
        persons.add(new Person("Martin", "Odersky", "1958-09-15"));

//        List<String> peroneNames = new ArrayList<>();
//        for(Person p: persons){
//            peroneNames.add(p.getFirstName());
//        }

//        List<String> peroneNames =
//                persons.stream()
//                        .map(Person::getFirstName)
//                        .collect(Collectors.toList());

        List<String> peroneNames =
                persons.stream()
                        .filter(p -> p.getFirstName().equals("Richard"))
                        .sorted((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : p1.getAge() == p2.getAge() ? 0 : -1)
                        .map(Person::toString)
                        .collect(Collectors.toList());

        peroneNames.stream().forEach(System.out::println);
    }
}
