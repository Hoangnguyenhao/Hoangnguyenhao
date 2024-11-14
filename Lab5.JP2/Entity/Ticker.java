package Entity;

public class Ticker {
        private int id;
        private String symbol;
        private String exchange;
        private String companyName;

        public Ticker(int id, String symbol, String exchange, String companyName) {
            this.id = id;
            this.symbol = symbol;
            this.exchange = exchange;
            this.companyName = companyName;
        }

        public int getId() {
            return id;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getExchange() {
            return exchange;
        }

        public String getCompanyName() {
            return companyName;
        }

        @Override
        public String toString() {
            return "Ticker{" +
                    "id=" + id +
                    ", symbol='" + symbol + '\'' +
                    ", exchange='" + exchange + '\'' +
                    ", companyName='" + companyName + '\'' +
                    '}';
        }
    }

