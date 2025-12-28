package metro_system;

import java.util.Date;

public class BookingService {

    private final BookingCardDAO bookingDAO = new BookingCardDAO();
    private final SmartCardDAO smartCardDAO = new SmartCardDAO();

    public double applyDiscount(double fare, String cardType) {
        if ("standard".equalsIgnoreCase(cardType)) {
            return fare * 0.90;
        }
        return fare * 0.85;
    }

    public void validateCard(FareCardInfo info) {
        if (info == null) {
            throw new IllegalStateException("Invalid route or card");
        }
        if (new Date().after(info.getExpiryDate())) {
            throw new IllegalStateException("Card has expired");
        }
    }

    public double calculateRemainingBalance(double balance, double fare) {
        if (balance < fare) {
            throw new IllegalStateException("Insufficient balance");
        }
        return balance - fare;
    }

    public void completeBooking(BookingCard booking) throws Exception {
        bookingDAO.insertBooking(booking);
        smartCardDAO.updateBalance(
                booking.getCardId(),
                booking.getRemainingBalance()
        );
    }
}
