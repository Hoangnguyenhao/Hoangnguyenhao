import Entity.Pricing;
import Entity.Security;
import Entity.Ticker;
import Service.SecurityService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
       Ticker apple = new Ticker(1, "AAPL", "NASDAQ", "Apple Inc.");
        Ticker google = new Ticker(2, "GOOGL", "NASDAQ", "Alphabet Inc.");
        Ticker amazon = new Ticker(3, "AMZN", "NASDAQ", "Amazon.com, Inc.");

        List<Ticker> tickers = Arrays.asList(apple, google, amazon);

        Pricing applePricing1 = new Pricing(1, apple.getId(), LocalDateTime.of(2024, 11, 14, 9, 0), 150.0, 155.0, 153.0);
        Pricing applePricing2 = new Pricing(2, apple.getId(), LocalDateTime.of(2024, 11, 14, 10, 0), 153.0, 157.0, 156.0);

        Pricing googlePricing1 = new Pricing(3, google.getId(), LocalDateTime.of(2024, 11, 14, 9, 0), 2750.0, 2775.0, 2765.0);
        Pricing googlePricing2 = new Pricing(4, google.getId(), LocalDateTime.of(2024, 11, 14, 10, 0), 2765.0, 2790.0, 2785.0);

        List<Pricing> pricings = Arrays.asList(applePricing1, applePricing2, googlePricing1, googlePricing2);

        Security stock = new Security("Stock");
        Security bond = new Security("Bond");
        List<Security> securities = Arrays.asList(stock, bond);

        SecurityService service = new SecurityService();

        List<Security> stockSecurities = service.filterStockSecurities(securities);
        System.out.println("Filtered Stock Securities: " + stockSecurities);

        Map<String, List<Ticker>> tickersByExchange = service.groupTickersByExchange(tickers);
        System.out.println("Grouped Tickers by Exchange: " + tickersByExchange);

        double averageClosePrice = service.calculateAverageClosePrice(pricings);
        System.out.println("Average Close Price: " + averageClosePrice);

        Map<Boolean, List<Pricing>> partitionedByPrice = service.partitionByPrice(pricings);
        System.out.println("Pricing Partitioned by Price > 100: " + partitionedByPrice);

        Optional<Pricing> highestPrice = service.findHighestPrice(pricings);
        highestPrice.ifPresent(p -> System.out.println("Highest Price: " + p.getClosePrice()));

        Map<String, Ticker> tickerMap = service.collectTickersIntoMap(tickers);
        System.out.println("Ticker Map: " + tickerMap);

        String tickerSymbols = service.joinTickerSymbols(tickers);
        System.out.println("Joined Ticker Symbols: " + tickerSymbols);

        Map<String, Map<LocalDateTime, List<Pricing>>> multiLevelGrouping = service.multiLevelGroupPricing(pricings, tickers);
        System.out.println("Multi-level Grouping by Symbol and DateTime: " + multiLevelGrouping);
    }
}
