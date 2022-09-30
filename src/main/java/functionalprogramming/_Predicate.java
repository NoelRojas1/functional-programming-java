package functionalprogramming;


import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Predicates represent a function that accept one argument and return a boolean (true or false)
 */

public class _Predicate {
    public static void main(String[] args) {
        String email1 = "johndoe@gmail.com";
        String email2 = "johndoe@gmail.net";

        System.out.printf("Is %s valid? %s%n", email1, isEmailValid.test(email1)); // valid
        System.out.printf("Is %s valid? %s%n", email2, isEmailValid.test(email2)); // not valid
        System.out.println();


        /**
         * We can chain Predicates by using the methods ".and" and ".or"
         * This will help us check different aspects for a given input.
         */
        String email3 = "johndoe@hotmail.com";
        System.out.printf("Is %s valid and contains gmail? %s%n", email1, isEmailValid.and(isGmail).test(email1)); // valid and gmail
        System.out.printf("Is %s valid and contains gmail? %s%n", email3, isEmailValid.and(isGmail).test(email3)); // valid but not gmail'
        System.out.println();

        System.out.printf("Is %s valid or contains gmail? %s%n", email1, isEmailValid.or(isGmail).test(email1)); // valid and gmail
        System.out.printf("Is %s valid or contains gmail? %s%n", email2, isEmailValid.or(isGmail).test(email2)); // invalid but gmail'
        System.out.println();


        /**
         * BiPredicates.
         *
         * Represent a function that accepts 2 arguments and return a boolean value.
         * This is useful when comparing 2 object for equality or inequality
         */
        int num1 = 5, num2 = 10, num3 = 5;
        String str1 = "Hello", str2 = "World", str3 = "hello";
        System.out.printf("Is %d greater than %d? %s%n", num1, num2, isGreaterThan.test(num1, num2)); // false
        System.out.printf("Is %d greater than %d? %s%n", num2, num1, isGreaterThan.test(num2, num1)); // true
        System.out.printf("Is %d greater than %d? %s%n", num1, num3, isGreaterThan.test(num1, num3)); // false
        System.out.printf("Are (%s) and (%s) equal? %s%n", str1, str2, isEqualTo.test(str1, str2));
        System.out.printf("Are (%s) and (%s) equal? %s%n", str1, str3, isEqualTo.test(str1, str3));
    }

    /**
     * In this example, for simplicity, we say that only emails ending in
     * "gmail.com","hotmail.com" and "yahoo.com" are valid.
     */
    static Predicate<String> isEmailValid = email -> {
        List<String> validDomains = List.of("gmail.com","hotmail.com","yahoo.com");
        String emailParts[] = email.split("@");
        return validDomains.contains(emailParts[1]);
    };

    static Predicate<String> isGmail = email -> {
        String emailParts[] = email.split("@");
        return emailParts[1].contains("gmail");
    };

    static BiPredicate<Integer, Integer> isGreaterThan = (num1, num2) -> num1 > num2;
    static BiPredicate<String, String> isEqualTo = (str1, str2) -> str1.equalsIgnoreCase(str2);
}
