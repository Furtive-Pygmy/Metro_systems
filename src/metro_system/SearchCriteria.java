package metro_system;

public class SearchCriteria {
    private String fromRoute;
    private String fromStation;
    private String toRoute;
    private String toStation;
    private String cardId;
    public SearchCriteria(String fromRoute, String fromStation,
                          String toRoute, String toStation,
                          String cardId) {
        this.fromRoute = fromRoute;
        this.fromStation = fromStation;
        this.toRoute = toRoute;
        this.toStation = toStation;
        this.cardId = cardId;
    }

    public String getFromRoute() {
        return fromRoute;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToRoute() {
        return toRoute;
    }

    public String getToStation() {
        return toStation;
    }

    public String getCardId() {
        return cardId;
    }
}
