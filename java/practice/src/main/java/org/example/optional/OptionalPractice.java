package org.example.optional;

import java.util.Optional;

public class OptionalPractice {
    public static void main(String[] args) {
        testOptional();
    }

    private static void testOptional() {
        String name = "Dhiman";
        Optional<String> nameOptional = Optional.ofNullable(name);
        nameOptional.ifPresentOrElse(
                n  -> System.out.println("Name is present"),
                () -> System.out.println("Name is not present!")
        );

//        if (nameOptional.isPresent()){}
//        if (nameOptional.isEmpty()){}
//        String n = nameOptional.orElse("Anonymous");
//        nameOptional.orElse(callMe());
        nameOptional.orElseGet(OptionalPractice::callMe);
    }

    private static String callMe() {
        System.out.println("Called Me");
        return "Anonymous";
    }
}
