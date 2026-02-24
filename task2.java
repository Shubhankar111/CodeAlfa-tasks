import java.util.*;

class Stock {
    String symbol;
    String name;
    double price;

    Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    void displayStock() {
        System.out.println(symbol + " - " + name + " : ₹" + price);
    }
}

class User {
    String name;
    double balance;
    Map<String, Integer> portfolio = new HashMap<>();

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void buyStock(Stock stock, int quantity) {
        double totalCost = stock.price * quantity;

        if (balance >= totalCost) {
            balance -= totalCost;
            portfolio.put(stock.symbol,
                portfolio.getOrDefault(stock.symbol, 0) + quantity);
            System.out.println("Stock Purchased Successfully!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void sellStock(Stock stock, int quantity) {
        if (portfolio.getOrDefault(stock.symbol, 0) >= quantity) {
            balance += stock.price * quantity;
            portfolio.put(stock.symbol,
                portfolio.get(stock.symbol) - quantity);
            System.out.println("Stock Sold Successfully!");
        } else {
            System.out.println("Not enough stocks to sell!");
        }
    }

    void showPortfolio() {
        System.out.println("Portfolio: " + portfolio);
        System.out.println("Balance: ₹" + balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock s1 = new Stock("TCS", "Tata Consultancy", 3500);
        Stock s2 = new Stock("INFY", "Infosys", 1500);

        User user = new User("Rohan", 100000);

        while (true) {
            System.out.println("\n1.View Stocks\n2.Buy\n3.Sell\n4.Portfolio\n5.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    s1.displayStock();
                    s2.displayStock();
                    break;

                case 2:
                    System.out.println("Enter 1 for TCS, 2 for INFY:");
                    int buyChoice = sc.nextInt();
                    System.out.println("Enter quantity:");
                    int qty = sc.nextInt();

                    if (buyChoice == 1)
                        user.buyStock(s1, qty);
                    else
                        user.buyStock(s2, qty);
                    break;

                case 3:
                    System.out.println("Enter 1 for TCS, 2 for INFY:");
                    int sellChoice = sc.nextInt();
                    System.out.println("Enter quantity:");
                    int sellQty = sc.nextInt();

                    if (sellChoice == 1)
                        user.sellStock(s1, sellQty);
                    else
                        user.sellStock(s2, sellQty);
                    break;

                case 4:
                    user.showPortfolio();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}