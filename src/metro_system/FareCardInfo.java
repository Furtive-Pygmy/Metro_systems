package metro_system;

import java.util.Date;

public class FareCardInfo {

    private final double fare;
    private final double balance;
    private final String cardType;
    private final Date expiryDate;
    private final String time;
    private final String distance;
    private final String stationsBetween;

    public FareCardInfo(double fare, double balance, String cardType,
                        Date expiryDate, String time,
                        String distance, String stationsBetween) {

        this.fare = fare;
        this.balance = balance;
        this.cardType = cardType;
        this.expiryDate = expiryDate;
        this.time = time;
        this.distance = distance;
        this.stationsBetween = stationsBetween;
    }

    public double getFare() { return fare; }
    public double getBalance() { return balance; }
    public String getCardType() { return cardType; }
    public Date getExpiryDate() { return expiryDate; }
    public String getTime() { return time; }
    public String getDistance() { return distance; }
    public String getStationsBetween() { return stationsBetween; }
}
