package metro_system;

public class SmartCard {

    private final String cardId;
    private final String name;
    private final String mobile;
    private final String cardType;
    private final double balance;

    public SmartCard(String cardId, String name, String mobile,
                     String cardType, double balance) {
        this.cardId = cardId;
        this.name = name;
        this.mobile = mobile;
        this.cardType = cardType;
        this.balance = balance;
    }

    public String getCardId() { return cardId; }
    public String getName() { return name; }
    public String getMobile() { return mobile; }
    public String getCardType() { return cardType; }
    public double getBalance() { return balance; }
}
