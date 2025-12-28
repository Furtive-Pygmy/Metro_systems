package metro_system;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StationDAO {

    public boolean insertStation(String route, String station) throws Exception {
        String query = "INSERT INTO stationtable VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, route);
            ps.setString(2, station);
            return ps.executeUpdate() > 0;
        }
    }
}
