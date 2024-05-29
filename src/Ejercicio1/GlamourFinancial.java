package Ejercicio1;

public interface GlamourFinancial {
    // Métodos para obtener la cotización de las acciones en diferentes mercados
    double getQuoteInMarket(String market);

    // Métodos para actualizar la cotización de las acciones en diferentes mercados
    void updateQuoteInMarket(String market, double quote);

    // Método para calcular el valor de mercado
    double calculateMarketValue(int numberOfShares);

    // Método para calcular el precio-valor en libras
    double calculatePriceValueInPounds(double exchangeRate);
}
