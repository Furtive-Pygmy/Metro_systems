package metro_system;

public class BookingCard {

    private String fromRoute;
    private String fromStation;
    private String toRoute;
    private String toStation;
    private String cardId;
    private double remainingBalance;
    private String bookingDate;
    private String bookingNo;

    public String getFromRoute() { return fromRoute; }
    public void setFromRoute(String fromRoute) { this.fromRoute = fromRoute; }

    public String getFromStation() { return fromStation; }
    public void setFromStation(String fromStation) { this.fromStation = fromStation; }

    public String getToRoute() { return toRoute; }
    public void setToRoute(String toRoute) { this.toRoute = toRoute; }

    public String getToStation() { return toStation; }
    public void setToStation(String toStation) { this.toStation = toStation; }

    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }

    public double getRemainingBalance() { return remainingBalance; }
    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public String getBookingNo() { return bookingNo; }
    public void setBookingNo(String bookingNo) { this.bookingNo = bookingNo; }
}
