package Ejercicio1;

import java.util.HashMap;
import java.util.Map;

public class GlamourFinancialImplementation implements GlamourFinancial {
    // Variables de instancia para mantener la cotización de las acciones en diferentes mercados
    private Map<String, Double> marketQuotes;

    // Constructor
    public GlamourFinancialImplementation() {
        marketQuotes = new HashMap<>();
    }

    @Override
    public double getQuoteInMarket(String market) {
        return marketQuotes.getOrDefault(market, 0.0);
    }

    @Override
    public void updateQuoteInMarket(String market, double quote) {
        marketQuotes.put(market, quote);
    }

    @Override
    public double calculateMarketValue(int numberOfShares) {
        double totalValue = 0.0;
        for (double quote : marketQuotes.values()) {
            totalValue += quote * numberOfShares;
        }
        return totalValue;
    }

    @Override
    public double calculatePriceValueInPounds(double exchangeRate) {
        double totalValueInPounds = 0.0;
        for (double quote : marketQuotes.values()) {
            totalValueInPounds += quote * exchangeRate;
        }
        return totalValueInPounds;
    }
}
