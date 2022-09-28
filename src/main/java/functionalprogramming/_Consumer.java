package functionalprogramming;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 *  The API for the functional interface of Java can be found here
 *  https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 *
 *  Consumer<T> represents an operation that accepts a single input argument of type T and returns no result.
 *  Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
 *
 */

public class _Consumer {
    public static void main(String[] args) {
        /**
         * We can use Consumers when we need to do an operation that doesn't require us
         * to return a value. It works pretty much like a void method
         */
        _User user = new _User("peterpan", "peter@example.com", "Peter", "Pan");
        greeting.accept(user);
        System.out.println("\n");

        /**
         * We can chain consumers together for different operations to work on the same input.
         */
        greeting.andThen(getDetails).accept(user);

        /**
         * BiConsumer represents an operation that accepts two input arguments and returns no result.
         * Same as with Consumers, BiConsumer works in a similar fashion as a void method.
         */
        _User newUser = new _User("javalover", "example@example.com", "Baki", "Hanma");
        System.out.println();
        makeConnections.accept(user, newUser);
    }

    static Consumer<_User> greeting = user -> {
        System.out.println(String.format("Welcome to our platform, %s.", user.getUserName()));
    };

    static Consumer<_User> getDetails = user -> {
        System.out.println(String.format("%s, we would like to know more about you!", user.getUsername()));
    };

    static BiConsumer<_User, _User> makeConnections = (user1, user2) -> {
        System.out.println("Notification:\n");
        System.out.println(String.format("%s, %s %s wants to send you a message!",
                user1.getUserName(), user2.getUserName(), user2.getUserLastName()));
    };

    static class _User {
        private String username;
        private String email;
        private String userName;
        private String userLastName;

        public _User(String username, String email, String userName, String userLastName) {
            this.username = username;
            this.email = email;
            this.userName = userName;
            this.userLastName = userLastName;
        }

        public String getUsername() {
            return username;
        }

        public String getUserName() {
            return userName;
        }

        public String getEmail() {
            return email;
        }

        public String getUserLastName() {
            return userLastName;
        }
    }
}
