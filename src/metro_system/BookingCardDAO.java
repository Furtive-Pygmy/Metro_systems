package metro_system;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookingCardDAO {

    public void insertBooking(BookingCard booking) throws Exception {

        String sql = "INSERT INTO bookingcard VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, booking.getFromRoute());
            ps.setString(2, booking.getFromStation());
            ps.setString(3, booking.getToRoute());
            ps.setString(4, booking.getToStation());
            ps.setString(5, booking.getCardId());
            ps.setDouble(6, booking.getRemainingBalance());
            ps.setString(7, booking.getBookingDate());
            ps.setString(12, booking.getBookingNo());

            ps.executeUpdate();
        }
    }
}
