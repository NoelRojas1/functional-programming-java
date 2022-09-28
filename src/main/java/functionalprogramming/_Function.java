package functionalprogramming;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * The API for the functional interface of Java can be found here
 * https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 *
 * Function<T, R> represents a function that accepts an argument of type T and reproduces a result of type R
 */

public class _Function {
    public static void main(String[] args) {
        int num = 1;
        System.out.println("Before increment: " + num); // 1
        System.out.println(" After increment: " + incrementByOne.apply(num)); // 2

        /**
         * We can also chain functions and combine them to work on an input
         */
        System.out.println("\nBefore increment: " + num); // 1
        System.out.println("After increment and multiplication: " +
                incrementByOne.andThen(multiplyByTen).apply(num)); // 20


        /**
         * The functional interface API also counts with a BiFunction.
         *
         * A BiFunction is a function that takes 2 arguments and produces a result.
         * BiFunction<T, U, R> where T is the type of first argument, U is the type of the
         * second argument and R is the type of the result.
         */
        System.out.println("\nBefore incrementing by 5: " + num); // 1
        System.out.println(" After incrementing by 5: " + incrementByQuantity.apply(num, 5)); // 6


        /**
         * BiFunctions cannot be chained with other BiFunctions,
         * but BiFunctions can be chained together with Functions
         * so that both BiFunction and Function can act on a specified inout
         */
        System.out.println("\nBefore incrementing by 5 and multiplying by 10: " + num); // 1
        System.out.println(" After incrementing by 5 and multiplying by 10: " +
                incrementByQuantity.andThen(multiplyByTen).apply(num, 5)); // 60

    }

    static Function<Integer, Integer> incrementByOne = num -> num + 1;
    static Function<Integer, Integer> multiplyByTen = num -> num * 10;
    static BiFunction<Integer, Integer, Integer> incrementByQuantity = (num1, num2) -> num1 + num2;
    static BiFunction<Integer, Integer, Integer> multiplyByQuantity = (num1, num2) -> num1 * num2;
}
