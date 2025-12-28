package metro_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SmartCardDAO {

    public List<SmartCard> search(String cardId, String name) {
        List<SmartCard> list = new ArrayList<>();

        String query = "SELECT s_id, name, mobile, card_type, balanceFROM smartcardWHERE s_id LIKE ? AND name LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, "%" + cardId + "%");
            ps.setString(2, "%" + name + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SmartCard(
                    rs.getString("s_id"),
                    rs.getString("name"),
                    rs.getString("mobile"),
                    rs.getString("card_type"),
                    rs.getDouble("balance")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public double getBalance(String cardId) {
        String query = "SELECT balance FROM smartcard WHERE s_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, cardId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double addBalance(String cardId, double amount) {
        String update = "UPDATE smartcard SET balance = balance + ? WHERE s_id = ?";
        String select = "SELECT balance FROM smartcard WHERE s_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(update);
            ps.setDouble(1, amount);
            ps.setString(2, cardId);
            ps.executeUpdate();

            ps = con.prepareStatement(select);
            ps.setString(1, cardId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
