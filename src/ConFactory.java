import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConFactory {

    public Connection getConnection() throws ClassNotFoundException, SQLException,
            IOException {

        try(FileInputStream fis = new FileInputStream("database.properties")) {
            Properties prop = new Properties();
            prop.load(fis);
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    prop.getProperty("url"),
                    prop.getProperty("user"),
                    prop.getProperty("password")
            );
        }

    }

}
