package metro_system;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FareDAO {

    public List<String> getRoutes() throws SQLException {
        List<String> routes = new ArrayList<>();
        String sql = "SELECT route FROM routetable";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                routes.add(rs.getString("route"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return routes;
    }

    public List<String> getStationsForRoute(String route) throws SQLException {
        List<String> stations = new ArrayList<>();
        String sql = "SELECT stn_name FROM stationtable WHERE route=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, route);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                stations.add(rs.getString("stn_name"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }

    public boolean insertFare(Fare fare) throws SQLException {
        String sql = "INSERT INTO faretable VALUES (?,?,?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps1 = con.prepareStatement(sql);
             PreparedStatement ps2 = con.prepareStatement(sql)) {

            fillStatement(ps1,
                    fare.getFromRoute(),
                    fare.getFromStation(),
                    fare.getToRoute(),
                    fare.getToStation(),
                    fare);

            fillStatement(ps2,
                    fare.getFromRoute(),
                    fare.getToStation(),
                    fare.getToRoute(),
                    fare.getFromStation(),
                    fare);

            return ps1.executeUpdate() > 0 && ps2.executeUpdate() > 0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void fillStatement(PreparedStatement ps,
                               String fromRoute, String fromStation,
                               String toRoute, String toStation,
                               Fare fare) throws SQLException {

        ps.setString(1, fromRoute);
        ps.setString(2, fromStation);
        ps.setString(3, toRoute);
        ps.setString(4, toStation);
        ps.setString(5, fare.getFare());
        ps.setString(6, fare.getTime());
        ps.setString(7, fare.getDistance());
        ps.setString(8, fare.getStationsBetween());
    }

    public FareCardInfo getFareForBooking(
        String fromRoute, String fromStation,
        String toRoute, String toStation,
        String cardId) throws SQLException {

    String sql = "SELECT f.fare, f.time, f.distance, f.stations_between, " +
             "s.balance, s.cardtype, s.expiry_date " +
             "FROM faretable f " +
             "JOIN smartcard s ON s.s_id = ? " +
             "WHERE f.route1 = ? AND f.stn1 = ? AND f.route2 = ? AND f.stn2 = ?";



    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, cardId);
        ps.setString(2, fromRoute);
        ps.setString(3, fromStation);
        ps.setString(4, toRoute);
        ps.setString(5, toStation);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new FareCardInfo(
                    rs.getDouble("fare"),
                    Double.parseDouble(rs.getString("balance")), // convert String to double
                    rs.getString("cardtype"),
                    rs.getDate("expiry_date"),
                    rs.getString("time"),
                    rs.getString("distance"),
                    rs.getString("stations_between")
            );
        }
    }catch (Exception e) {
            e.printStackTrace();
        }
    return null;
}

}
