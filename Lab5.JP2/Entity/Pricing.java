package Entity;
import java.time.LocalDateTime;

public class Pricing {
    private int id;
    private int tickerID;
    private LocalDateTime dateTime;
    private double openPrice;
    private double closePrice;
    private double currentPrice;

    public Pricing(int id, int tickerID, LocalDateTime dateTime, double openPrice, double closePrice, double currentPrice) {
        this.id = id;
        this.tickerID = tickerID;
        this.dateTime = dateTime;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.currentPrice = currentPrice;
    }

    public int getId() {
        return id;
    }

    public int getTickerID() {
        return tickerID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public String toString() {
        return "Pricing{" +
                "id=" + id +
                ", tickerID=" + tickerID +
                ", dateTime=" + dateTime +
                ", openPrice=" + openPrice +
                ", closePrice=" + closePrice +
                ", currentPrice=" + currentPrice +
                '}';
    }
}