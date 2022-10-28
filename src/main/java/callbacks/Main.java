package callbacks;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * In Java we can use Functions as callback functions just as in JavaScript
 */

public class Main {
    public static void main(String[] args) {
        greet("Noel", null, cb);
        greet("Noel", "rojas", cb);
        performOperation(7, 10, '+', addAndReturn);
        performOperation(7, 10, '-', subtractAndReturn);
        performOperation(7, 10, '*', multiplyAndReturn);
    }

    static Consumer<String> cb = (s1) -> System.out.println("No last name provided. First name: " + s1);
    public static void greet(String firstName, String lastName, Consumer<String> callback) {
        if(lastName != null) {
            System.out.println(firstName + " " + lastName);
        } else {
            callback.accept(firstName);
        }
    }

    /**
     * This example is somewhat more useful but still very easy to understand.
     *
     * We create a method that accepts a callback and we create multiple functions that are of the callback type.
     * Now we can perform different operations using the same performOperation method and we do not have to
     * write any if statements. AWESOME.
     */
    static BiFunction<Integer, Integer, Integer> multiplyAndReturn = (num1, num2) -> num1 * num2;
    static BiFunction<Integer, Integer, Integer> addAndReturn = (num1, num2) -> num1 + num2;
    static BiFunction<Integer, Integer, Integer> subtractAndReturn = (num1, num2) -> num1 - num2;
    public static void performOperation(int num1, int num2, char operation, BiFunction<Integer, Integer, Integer> cb) {
        System.out.println(String.format("%d %c %d = %d", num1, operation, num2, cb.apply(num1, num2)));
    }
}
