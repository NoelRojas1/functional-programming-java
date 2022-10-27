package optionals;

import java.util.Optional;

/**
 * Optionals are a way for us to work with lambdas and functional programming and at the
 * same time they allow us to work with nullable objects in a much better way.
 *
 * The Optionals API supplies us with so many useful methods to work with such as:
 * orElseGet
 * ifPresent
 * ifPresentOrElse
 *
 * etc
 *
 * API docs: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
 */

public class Main {
    public static void main(String[] args) {
        /**
         * If we have an object that may possibly be null, we can define a default value
         * or throw an error, etc.
         */
        Object o = Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        System.out.println(o);

        /**
         * If the object is not null, then it will be returned
         */
        Object value = Optional.ofNullable("Hello")
                .orElseThrow(() -> new IllegalStateException());
        System.out.println(value);


        /**
         * We can also check if the value is present and then do something with it.
         */
        Optional.ofNullable("example@example.com")
                .ifPresent((x) -> {
                    // logic such as save to DB, make API call, make HTTP request, etc
                    System.out.println("Sending email to " + x);
                });

        /**
         * We can also use ifPresentOrElse which takes a consumer and a runnable to perform in case the object
         * is not present
         */
        Optional.ofNullable("example@eample.com")
                .ifPresentOrElse((x) -> {
                    // logic such as save to DB, make API call, make HTTP request, etc
                    System.out.println("Sending email to " + x);
                }, () -> {
                    System.out.println("Object not present.");
                });
        Optional.ofNullable(null)
                .ifPresentOrElse((x) -> {
                    // logic such as save to DB, make API call, make HTTP request, etc
                    System.out.println("Sending email to " + x);
                }, () -> {
                    System.out.println("Object not present.");
                });
    }
}
