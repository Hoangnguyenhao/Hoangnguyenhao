package Service;
import Entity.Pricing;
import Entity.Ticker;
import Entity.Security;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class SecurityService {

    public List<Security> filterStockSecurities(List<Security> securities) {
        return securities.stream()
                .filter(security -> "Stock".equals(security.getType()))
                .collect(Collectors.toList());
    }

    public Map<String, List<Ticker>> groupTickersByExchange(List<Ticker> tickers) {
        return tickers.stream()
                .collect(Collectors.groupingBy(Ticker::getExchange));
    }

    public double calculateAverageClosePrice(List<Pricing> pricings) {
        return pricings.stream()
                .mapToDouble(Pricing::getClosePrice)
                .average()
                .orElse(0.0);
    }

    public Map<Boolean, List<Pricing>> partitionByPrice(List<Pricing> pricings) {
        return pricings.stream()
                .collect(Collectors.partitioningBy(p -> p.getClosePrice() > 100));
    }

    public Optional<Pricing> findHighestPrice(List<Pricing> pricings) {
        return pricings.stream()
                .max(Comparator.comparingDouble(Pricing::getClosePrice));
    }

    public Map<String, Ticker> collectTickersIntoMap(List<Ticker> tickers) {
        return tickers.stream()
                .collect(Collectors.toMap(Ticker::getSymbol, ticker -> ticker));
    }

    public String joinTickerSymbols(List<Ticker> tickers) {
        return tickers.stream()
                .map(Ticker::getSymbol)
                .collect(Collectors.joining(", "));
    }

    public Map<String, Map<LocalDateTime, List<Pricing>>> multiLevelGroupPricing(List<Pricing> pricings, List<Ticker> tickers) {
        return pricings.stream()
                .collect(Collectors.groupingBy(
                        pricing -> tickers.stream()
                                .filter(t -> t.getId() == pricing.getTickerID())
                                .findFirst()
                                .get()
                                .getSymbol(),
                        Collectors.groupingBy(Pricing::getDateTime)
                ));
    }
}