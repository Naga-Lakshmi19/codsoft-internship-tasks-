import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class CurrencyConverter {
    private Map<String, Double> exchangeRates;
    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("GBP", 0.75);
        // Add more currencies as needed
    }
    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code.");
        }
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        return (amount / fromRate) * toRate;
    }
    public void addOrUpdateExchangeRate(String currency, double rate) {
        exchangeRates.put(currency, rate);
    }
    public void displayAvailableCurrencies() {
        System.out.println("Available currencies: " + exchangeRates.keySet());
    }
}
public class Currency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        System.out.println("Welcome to the Currency Converter!");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Convert currency");
            System.out.println("2. Add/Update exchange rate");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                converter.displayAvailableCurrencies();
                System.out.print("Enter the base currency: ");
                String baseCurrency = scanner.next().toUpperCase();
                System.out.print("Enter the target currency: ");
                String targetCurrency = scanner.next().toUpperCase();
                System.out.print("Enter the amount to convert: ");
                double amount = scanner.nextDouble();
                try {
                    double convertedAmount = converter.convert(baseCurrency, targetCurrency, amount);
                    System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 2) {
                System.out.print("Enter the currency code: ");
                String currency = scanner.next().toUpperCase();
                System.out.print("Enter the exchange rate against USD: ");
                double rate = scanner.nextDouble();
                converter.addOrUpdateExchangeRate(currency, rate);
                System.out.println("Exchange rate updated.");
            } else if (choice == 3) {
                System.out.println("Thank you for using the Currency Converter. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}