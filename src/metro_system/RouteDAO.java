package metro_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO {

    private static final String INSERT_ROUTE =
            "INSERT INTO routetable VALUES (?)";

    public boolean addRoute(String routeName) throws SQLException {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_ROUTE)) {

            ps.setString(1, routeName);
            return ps.executeUpdate() > 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> fetchRoutes() throws Exception {
        List<String> routes = new ArrayList<>();

        String query = "SELECT route FROM routetable";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                routes.add(rs.getString("route"));
            }
        }
        return routes;
    }




}
