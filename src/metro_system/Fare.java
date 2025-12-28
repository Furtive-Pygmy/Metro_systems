package metro_system;

public class Fare {

    private final String fromRoute;
    private final String toRoute;
    private final String fromStation;
    private final String toStation;
    private final String fare;
    private final String time;
    private final String distance;
    private final String stationsBetween;

    public Fare(String fromRoute, String toRoute,
                String fromStation, String toStation,
                String fare, String time,
                String distance, String stationsBetween) {

        this.fromRoute = fromRoute;
        this.toRoute = toRoute;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.fare = fare;
        this.time = time;
        this.distance = distance;
        this.stationsBetween = stationsBetween;
    }
    

    public String getFromRoute() { return fromRoute; }
    public String getToRoute() { return toRoute; }
    public String getFromStation() { return fromStation; }
    public String getToStation() { return toStation; }
    public String getFare() { return fare; }
    public String getTime() { return time; }
    public String getDistance() { return distance; }
    public String getStationsBetween() { return stationsBetween; }
}
