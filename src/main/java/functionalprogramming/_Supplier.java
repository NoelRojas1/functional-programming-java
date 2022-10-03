package functionalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Suppliers represents a supplier of results.
 * There is no requirement that a new or distinct result be returned each time the supplier is invoked.
 * Basically a Supplier<T> gives us something in return of type T, and it does not take any parameter(s)
 * and we use the .get() method of the Supplier interface to obtain the result of the supplier.
 */
public class _Supplier {
    public static void main(String[] args) {
        System.out.println("Connection URL: " + getDBConnectionUrl.get());
        System.out.println("**************************************");
        System.out.println(getDBConnectionStrings.get());
    }

    static Supplier<String> getDBConnectionUrl = () -> {
        return "jdbc:postgres//localhost:5432/test";
    };

    static Supplier<List<DBConnection>> getDBConnectionStrings = () -> {
        List<DBConnection> connections = List.of(
                new DBConnection("mysql"),
                new DBConnection("postgres")
        );
        return connections;
    };

    static class DBConnection {
        private String dbName;

        public DBConnection(String dbName) {
            this.dbName = dbName;
        }

        public String getDbName() {
            return dbName;
        }

        @Override
        public String toString() {
            return String.format("DBConnection: {%s}", dbName);
        }
    }
}
