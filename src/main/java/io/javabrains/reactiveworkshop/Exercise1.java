package io.javabrains.reactiveworkshop;

import java.util.Optional;
import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(integer -> integer <=6).forEach(element -> { System.out.println(element);});

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().skip(1).limit(2).forEach(element -> {System.out.println(element);});

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        Optional<Integer> t = StreamSources.intNumbersStream().filter(element -> element > 5).findFirst();
        t.ifPresent(integer -> {System.out.println("Print First Number--->>>>"+integer);});


        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream().forEach(user -> {System.out.println(user.getFirstName());});

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        StreamSources.intNumbersStream().flatMap(id ->
                                                            StreamSources.userStream()
                                                                         .filter(user -> user.getId() == id))
                                        .map(user -> user.getFirstName())
                                        .forEach(name -> System.out.println(name));

    }

}
