import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    static String driver="com.mysql.cj.jdbc.Driver";
    static   String databaseurl="jdbc:mysql://localhost:3306/employee";
    static String UN="root";
    static String PS="password";

    public DB() throws SQLException {
    }

    public static Connection getConnection( )throws SQLException,ClassNotFoundException{
        Class.forName(driver);
        Connection connection= DriverManager.getConnection(databaseurl,UN,PS);
        System.out.println("Database connected");
        return connection;
    }
}
