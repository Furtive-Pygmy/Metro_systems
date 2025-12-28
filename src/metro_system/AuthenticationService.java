package metro_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class AuthenticationService implements convar {

    public UserRole authenticate(Credentials credentials) {

        try (Connection con = DriverManager.getConnection(
                path + place, username, password)) {

            if (isValidUser(con, "admintable", credentials)) {
                return UserRole.ADMIN;
            }

            if (isValidUser(con, "employeetable", credentials)) {
                return UserRole.EMPLOYEE;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Authentication Error: " + e.getMessage());
        }

        return UserRole.NONE;
    }

    private boolean isValidUser(Connection con,
                                String table,
                                Credentials credentials) throws Exception {

        String query =
                "SELECT * FROM " + table +
                " WHERE USERNAME=? AND PASSWORD=?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, credentials.getUsername());
        ps.setString(2, credentials.getPassword());

        return ps.executeQuery().next();
    }
}
