package metro_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection implements convar {

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(path + place, username, password);
    }
}
